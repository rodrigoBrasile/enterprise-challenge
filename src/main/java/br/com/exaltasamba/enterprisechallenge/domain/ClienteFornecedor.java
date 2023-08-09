package br.com.exaltasamba.enterprisechallenge.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClienteFornecedor {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private String cpfCnpj;
        private String email;

        @AttributeOverrides({
                @AttributeOverride(name="tipo",
                        column=@Column(name="telefone1_tipo")),
                @AttributeOverride(name="numero",
                        column=@Column(name="telefone1_numero"))
        })
        @Embedded
        private Telefone telefone1;

        @AttributeOverrides({
                @AttributeOverride(name="tipo",
                        column=@Column(name="telefone2_tipo")),
                @AttributeOverride(name="numero",
                        column=@Column(name="telefone2_numero"))
        })
        @Embedded
        private Telefone telefone2;

        @Embedded
        private Endereco endereco;

        public ClienteFornecedor() {
        }

        public ClienteFornecedor(String nome, String cpfCnpj, String email, Telefone telefone1, Telefone telefone2, Endereco endereco) {
                this.nome = nome;
                this.cpfCnpj = cpfCnpj;
                this.email = email;
                this.telefone1 = telefone1;
                this.telefone2 = telefone2;
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
        public String getCpfCnpj() {
                return cpfCnpj;
        }
        public void setCpfCnpj(String documento) {
                this.cpfCnpj = documento;
        }
        public String getEmail() {
                return email;
        }
        public void setEmail(String email) {
                this.email = email;
        }

        public Telefone getTelefone1() {
                return telefone1;
        }

        public void setTelefone1(Telefone telefone1) {
                this.telefone1 = telefone1;
        }

        public Telefone getTelefone2() {
                return telefone2;
        }

        public void setTelefone2(Telefone telefone2) {
                this.telefone2 = telefone2;
        }

        public Endereco getEndereco() {
                return endereco;
        }
        public void setEndereco(Endereco endereco) {
                this.endereco = endereco;
        }
}
