package br.com.exaltasamba.enterprisechallenge.presentation.material;

import br.com.exaltasamba.enterprisechallenge.domain.Material;
import br.com.exaltasamba.enterprisechallenge.domain.MaterialRepository;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialController {
    private final MaterialRepository materialRepository;

    public MaterialController(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    @CrossOrigin
    @GetMapping("/material")
    public List<Material> buscaTodos() {
        return Streamable.of(materialRepository.findAll()).stream().toList();
    }

}
