package br.com.exaltasamba.enterprisechallenge.domain;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario cadastraUsuario(String nome, String senha1, String senha2) {
        // valida as senhas
        var usuario = new Usuario(nome, senha1);

        usuarioRepository.save(usuario);

        return usuario;
    }

}
