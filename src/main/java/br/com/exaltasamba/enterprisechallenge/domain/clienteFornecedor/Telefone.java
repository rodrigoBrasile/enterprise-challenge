package br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor;


import jakarta.persistence.*;

@Embeddable
public class Telefone {

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;
    private String numero;

    public Telefone() {
    }

    public Telefone(TipoTelefone tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }
    public void setTipo(TipoTelefone tipoTelefone) {
        this.tipo = tipoTelefone;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
