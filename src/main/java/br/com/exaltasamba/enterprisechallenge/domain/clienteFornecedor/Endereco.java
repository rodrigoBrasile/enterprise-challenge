package br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor;


import jakarta.persistence.*;

@Embeddable
public class Endereco {

    @Column(name = "endero_logradouro")
    private String logradouro;
    @Column(name = "endero_numero")
    private String numero;
    @Column(name = "endero_bairro")
    private String bairro;
    @Column(name = "endero_estado")
    private String estado;
    @Column(name = "endero_cep")
    private String cep;

    public Endereco() {
    }

    public Endereco(String tipo, String logradouro, String numero, String bairro, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
