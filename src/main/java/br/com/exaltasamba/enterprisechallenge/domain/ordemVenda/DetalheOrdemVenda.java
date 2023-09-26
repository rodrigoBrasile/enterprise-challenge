package br.com.exaltasamba.enterprisechallenge.domain.ordemVenda;

import br.com.exaltasamba.enterprisechallenge.domain.produto.Produto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class DetalheOrdemVenda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne @JoinColumn(name="id_produto")
    private Produto produto;

    private BigDecimal quantidade;
    private BigDecimal desconto;

    public DetalheOrdemVenda(Produto produto, BigDecimal quantidade, BigDecimal desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public DetalheOrdemVenda() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto material) {
        this.produto = material;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
