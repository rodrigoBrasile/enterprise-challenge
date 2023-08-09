package br.com.exaltasamba.enterprisechallenge.presentation.material;

import br.com.exaltasamba.enterprisechallenge.domain.Material;
import br.com.exaltasamba.enterprisechallenge.domain.MaterialRepository;
import br.com.exaltasamba.enterprisechallenge.domain.MaterialService;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialController {
    private final MaterialRepository materialRepository;
    private final MaterialService materialService;

    public MaterialController(MaterialRepository materialRepository, MaterialService materialService) {
        this.materialRepository = materialRepository;
        this.materialService = materialService;
    }


    @CrossOrigin
    @GetMapping("/material")
    public List<Material> buscaTodos() {
        return Streamable.of(materialRepository.findAll()).stream().toList();
    }

    @CrossOrigin
    @GetMapping("/material/{id}")
    public Material busca(@PathVariable int id) {
        return materialRepository.findById(id).orElseThrow();
    }

    @CrossOrigin
    @PostMapping("/material")
    public int cadastra(@RequestBody FormularioMaterial formulario) {
        var clienteFornecedor = materialService.cadastra(formulario.idFornecedor(), formulario.descricao(), formulario.unidade(), formulario.custo(), formulario.codigoFabricante());
        return clienteFornecedor.getId();
    }

    @CrossOrigin
    @PutMapping("/material/{id}")
    public void atualiza(@PathVariable int id, @RequestBody FormularioMaterial formulario) {
        materialService.atualiza(id,  formulario.descricao(), formulario.unidade(), formulario.custo(), formulario.codigoFabricante());
    }

    @CrossOrigin
    @DeleteMapping("/material/{id}")
    public void deleta(@PathVariable int id) {
        materialService.deleta(id);
    }

}
