package br.com.exaltasamba.enterprisechallenge.presentation;

import br.com.exaltasamba.enterprisechallenge.domain.Usuario;
import br.com.exaltasamba.enterprisechallenge.domain.UsuarioRepository;
import br.com.exaltasamba.enterprisechallenge.domain.UsuarioService;
import org.springframework.data.util.Streamable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/usuario")
    public Integer cadastra(@RequestBody Formulario formulario) {
        var usuario = usuarioService.cadastraUsuario(formulario.nome(), formulario.senha(), formulario.senha2());
        return usuario.getId();
    }

    @GetMapping("/usuario/all")
    public List<Usuario> buscaTodos() {
        return Streamable.of(usuarioRepository.findAll()).stream().toList();
    }

    @GetMapping("/usuario/{idUsuario}")
    public Usuario busca(@PathVariable Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

}
