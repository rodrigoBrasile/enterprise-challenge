package br.com.exaltasamba.enterprisechallenge.domain.produto;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private BigDecimal preco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) @JoinColumn(name="id_produto", nullable = false)
    private List<DetalheProduto> detalhes;

    public Produto(String descricao, BigDecimal preco, List<DetalheProduto> detalhes) {
        this.descricao = descricao;
        this.preco = preco;
        this.detalhes = detalhes;
    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<DetalheProduto> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<DetalheProduto> detalhes) {
        this.detalhes = detalhes;
    }
}
