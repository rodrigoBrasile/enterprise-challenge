package br.com.exaltasamba.enterprisechallenge.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClienteFornecedor {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private String documento;
        private String email;
        @ElementCollection
        @CollectionTable(
                name="telefone",
                joinColumns=@JoinColumn(name="id_cliente_fornecedor")
        )
        private List<Telefone> telefones;

        @Embedded
        private Endereco endereco;

        public ClienteFornecedor() {
        }

        public ClienteFornecedor(String nome, String documento, String email, List<Telefone> telefones, Endereco endereco) {
                this.nome = nome;
                this.documento = documento;
                this.email = email;
                this.telefones = telefones;
                this.endereco = endereco;
        }

        public Integer getId() {
                return id;
        }
        public void setId(Integer id) {
                this.id = id;
        }
        public String getNome() {
                return nome;
        }
        public void setNome(String nome) {
                this.nome = nome;
        }
        public String getDocumento() {
                return documento;
        }
        public void setDocumento(String documento) {
                this.documento = documento;
        }
        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }
        public List<Telefone> getTelefones() {
                return telefones;
        }
        public void setTelefones(List<Telefone> telefones) {
                this.telefones = telefones;
        }
        public Endereco getEndereco() {
                return endereco;
        }
        public void setEndereco(Endereco endereco) {
                this.endereco = endereco;
        }
}
