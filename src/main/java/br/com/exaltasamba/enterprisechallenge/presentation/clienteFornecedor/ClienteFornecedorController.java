package br.com.exaltasamba.enterprisechallenge.presentation.clienteFornecedor;

import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.ClienteFornecedor;
import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.ClienteFornecedorRepository;
import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.ClienteFornecedorService;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteFornecedorController {
    private final ClienteFornecedorService clienteFornecedorService;
    private final ClienteFornecedorRepository clienteFornecedorRepository;

    public ClienteFornecedorController(ClienteFornecedorService clienteFornecedorService, ClienteFornecedorRepository clienteFornecedorRepository) {
        this.clienteFornecedorService = clienteFornecedorService;
        this.clienteFornecedorRepository = clienteFornecedorRepository;
    }

    @CrossOrigin
    @GetMapping("/cliente-fornecedor")
    public List<ClienteFornecedor> buscaTodos() {
        return Streamable.of(clienteFornecedorRepository.findAll()).stream().toList();
    }

    @CrossOrigin
    @GetMapping("/cliente-fornecedor/{id}")
    public ClienteFornecedor busca(@PathVariable int id) {
        return clienteFornecedorRepository.findById(id).orElseThrow();
    }

    @CrossOrigin
    @PostMapping("/cliente-fornecedor")
    public int cadastra(@RequestBody FormularioClienteFornecedor formulario) {
        var clienteFornecedor = clienteFornecedorService.cadastra(formulario.nome(), formulario.cpfCnpj(), formulario.email(), formulario.telefone1(), formulario.telefone2(), formulario.endereco());
        return clienteFornecedor.getId();
    }

    @CrossOrigin
    @PutMapping("/cliente-fornecedor/{id}")
    public void atualiza(@PathVariable int id, @RequestBody FormularioClienteFornecedor formulario) {
        clienteFornecedorService.atualiza(id,  formulario.nome(), formulario.cpfCnpj(), formulario.email(), formulario.telefone1(), formulario.telefone2(), formulario.endereco());
    }

    @CrossOrigin
    @DeleteMapping("/cliente-fornecedor/{id}")
    public void deleta(@PathVariable int id) {
        clienteFornecedorService.deleta(id);
    }
}
