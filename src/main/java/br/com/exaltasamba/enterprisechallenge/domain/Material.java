package br.com.exaltasamba.enterprisechallenge.domain;

import jakarta.persistence.*;

@Entity
public class Material {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Embedded
    private ClienteFornecedor fornecedor;
    private String descricao;
    private tipoUnidade unidade;
    private double custo;


    public Material(int id, ClienteFornecedor fornecedor, String descricao, tipoUnidade unidade, double custo) {
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

    public tipoUnidade getUnidade() {
        return unidade;
    }

    public void setUnidade(tipoUnidade unidade) {
        this.unidade = unidade;
    }


    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
