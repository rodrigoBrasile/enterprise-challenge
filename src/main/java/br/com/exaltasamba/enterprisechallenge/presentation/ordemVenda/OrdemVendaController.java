package br.com.exaltasamba.enterprisechallenge.presentation.ordemVenda;

import br.com.exaltasamba.enterprisechallenge.domain.ordemVenda.OrdemVenda;
import br.com.exaltasamba.enterprisechallenge.domain.ordemVenda.OrdemVendaRepository;
import br.com.exaltasamba.enterprisechallenge.domain.ordemVenda.OrdemVendaService;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdemVendaController {
    private final OrdemVendaRepository ordemVendaRepository;
    private final OrdemVendaService ordemVendaService;

    public OrdemVendaController(OrdemVendaRepository ordemVendaRepository, OrdemVendaService ordemVendaService) {
        this.ordemVendaRepository = ordemVendaRepository;
        this.ordemVendaService = ordemVendaService;
    }

    @CrossOrigin
    @GetMapping("/ordem-venda")
    public List<OrdemVenda> buscaTodos() {
        return Streamable.of(ordemVendaRepository.findAll()).stream().toList();
    }

    @CrossOrigin
    @GetMapping("/ordem-venda/{id}")
    public OrdemVenda busca(@PathVariable int id) {
        return ordemVendaRepository.findById(id).orElseThrow();
    }

    @CrossOrigin
    @PostMapping("/ordem-venda")
    public int cadastra(@RequestBody FormularioOrdemVenda formulario) {
        var ordemVenda = ordemVendaService.cadastra(formulario.idCliente(), formulario.dataEntrega(), formulario.logradouro(), formulario.numero(), formulario.bairro(), formulario.estado(), formulario.cep(), formulario.informacoesAdicionais(), formulario.detalhes());
        return ordemVenda.getId();
    }

    @CrossOrigin
    @PutMapping("/ordem-venda/{id}")
    public void atualiza(@PathVariable int id, @RequestBody FormularioOrdemVenda formulario) {
        ordemVendaService.atualiza(id, formulario.dataEntrega(), formulario.logradouro(), formulario.numero(), formulario.bairro(), formulario.estado(), formulario.cep(),  formulario.informacoesAdicionais(), formulario.detalhes());
    }

    @CrossOrigin
    @DeleteMapping("/ordem-venda/{id}")
    public void deleta(@PathVariable int id) {
        ordemVendaService.deleta(id);
    }

}
