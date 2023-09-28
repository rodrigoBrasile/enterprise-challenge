package br.com.exaltasamba.enterprisechallenge.domain.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String hashSenha;

    private String perfil;


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public String getPerfil() {
        return perfil;
    }
}
