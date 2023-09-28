package br.com.exaltasamba.enterprisechallenge.domain.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario autentica(String username, String senha) {
        String hashSenha = AuthUtils.hash256(senha);
        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new AuthException("Usuário '" + username + "' não encontrado.");
        }

        if (!usuario.getHashSenha().equals(hashSenha)) {
            throw new AuthException("Senha do usuário '" + username + "' é inválida.");
        }

        return usuario;
    }

}
