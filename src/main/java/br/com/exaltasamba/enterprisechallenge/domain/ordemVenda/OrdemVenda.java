package br.com.exaltasamba.enterprisechallenge.domain.ordemVenda;

import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.ClienteFornecedor;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class OrdemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne @JoinColumn(name="id_cliente")
    private ClienteFornecedor clienteFornecedor;
    private LocalDate dataEntrega;

    private String logradouro;
    private String numero;
    private String bairro;
    private String estado;
    private String cep;
    private String informacoesAdicionais;
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) @JoinColumn(name="id_ordem_venda", nullable = false)
    private List<DetalheOrdemVenda> detalhes;

    public OrdemVenda(ClienteFornecedor clienteFornecedor, LocalDate dataEntrega, String logradouro, String numero, String bairro, String estado, String informacoesAdicionais, String cep, String status, List<DetalheOrdemVenda> detalhes) {
        this.clienteFornecedor = clienteFornecedor;
        this.dataEntrega = dataEntrega;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
        this.informacoesAdicionais = informacoesAdicionais;
        this.status = status;
        this.detalhes = detalhes;
    }

    public OrdemVenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
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

    public List<DetalheOrdemVenda> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<DetalheOrdemVenda> detalhes) {
        this.detalhes = detalhes;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public ClienteFornecedor getClienteFornecedor() {
        return clienteFornecedor;
    }

    public void setClienteFornecedor(ClienteFornecedor clienteFornecedor) {
        this.clienteFornecedor = clienteFornecedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
