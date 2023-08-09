package br.com.exaltasamba.enterprisechallenge.domain.produto;

import br.com.exaltasamba.enterprisechallenge.domain.material.Material;
import br.com.exaltasamba.enterprisechallenge.domain.material.MaterialRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final MaterialRepository materialRepository;

    public ProdutoService(ProdutoRepository produtoRepository, MaterialRepository materialRepository) {
        this.produtoRepository = produtoRepository;
        this.materialRepository = materialRepository;
    }
    @Transactional
    public Produto cadastra(String descricao, BigDecimal preco, List<DetalheProdutoDto> detalhes) {
        var produto = new Produto(
                descricao,
                preco,
                detalhes.stream()
                        .map(it -> {
                            Material material = materialRepository.findById(it.idMaterial()).orElseThrow();
                            return new DetalheProduto(material, it.quantidade());
                        })
                        .toList()
        );
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
