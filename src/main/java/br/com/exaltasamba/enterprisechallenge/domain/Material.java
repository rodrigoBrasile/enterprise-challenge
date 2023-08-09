package br.com.exaltasamba.enterprisechallenge.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Material {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne @JoinColumn(name="id_cliente_fornecedor")
    private ClienteFornecedor fornecedor;
    private String descricao;
    private TipoUnidade unidade;
    private BigDecimal custo;


    public Material(int id, ClienteFornecedor fornecedor, String descricao, TipoUnidade unidade, BigDecimal custo) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.unidade = unidade;
        this.custo = custo;
    }

    public Material() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteFornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(ClienteFornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoUnidade getUnidade() {
        return unidade;
    }

    public void setUnidade(TipoUnidade unidade) {
        this.unidade = unidade;
    }


    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
}
