package br.com.exaltasamba.enterprisechallenge.domain.produto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Transactional
    public Produto cadastra(String descricao, BigDecimal preco) {
        var produto = new Produto(descricao, preco);
        produtoRepository.save(produto);
        return produto;
    }

    @Transactional
    public void atualiza(int id, String descricao, BigDecimal preco) {
        var produto = produtoRepository.findById(id).orElseThrow();
        produto.setDescricao(descricao);
        produto.setPreco(preco);
    }

    @Transactional
    public void deleta(int id){
        produtoRepository.deleteById(id);
    }

}
