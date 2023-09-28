package br.com.exaltasamba.enterprisechallenge.domain.auth;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByUsername(String username);

}
