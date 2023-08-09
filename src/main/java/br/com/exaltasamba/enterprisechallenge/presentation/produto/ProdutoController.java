package br.com.exaltasamba.enterprisechallenge.presentation.produto;

import br.com.exaltasamba.enterprisechallenge.domain.produto.Produto;
import br.com.exaltasamba.enterprisechallenge.domain.produto.ProdutoRepository;
import br.com.exaltasamba.enterprisechallenge.domain.produto.ProdutoService;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }


    @CrossOrigin
    @GetMapping("/produto")
    public List<Produto> buscaTodos() {
        return Streamable.of(produtoRepository.findAll()).stream().toList();
    }

    @CrossOrigin
    @GetMapping("/produto/{id}")
    public Produto busca(@PathVariable int id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    @CrossOrigin
    @PostMapping("/produto")
    public int cadastra(@RequestBody FormularioProduto formulario) {
        var clienteFornecedor = produtoService.cadastra(formulario.descricao(), formulario.preco());
        return clienteFornecedor.getId();
    }

    @CrossOrigin
    @PutMapping("/produto/{id}")
    public void atualiza(@PathVariable int id, @RequestBody FormularioProduto formulario) {
        produtoService.atualiza(id,  formulario.descricao(), formulario.preco());
    }

    @CrossOrigin
    @DeleteMapping("/produto/{id}")
    public void deleta(@PathVariable int id) {
        produtoService.deleta(id);
    }

}
