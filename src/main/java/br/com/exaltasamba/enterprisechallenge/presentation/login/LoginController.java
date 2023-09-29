package br.com.exaltasamba.enterprisechallenge.presentation.login;

import br.com.exaltasamba.enterprisechallenge.domain.auth.AuthException;
import br.com.exaltasamba.enterprisechallenge.domain.auth.AuthService;
import br.com.exaltasamba.enterprisechallenge.domain.auth.Usuario;
import br.com.exaltasamba.enterprisechallenge.domain.material.Material;
import br.com.exaltasamba.enterprisechallenge.domain.material.MaterialRepository;
import br.com.exaltasamba.enterprisechallenge.domain.material.MaterialService;
import br.com.exaltasamba.enterprisechallenge.presentation.material.FormularioMaterial;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }


    @CrossOrigin
    @PostMapping("/login")
    public UsuarioDto login(@RequestBody FormularioLogin formularioLogin) {
        Usuario usuario = authService.autentica(formularioLogin.username(), formularioLogin.senha());

        String token = JwtTokenUtil.generateToken(usuario.getUsername());

        return new UsuarioDto(usuario.getUsername(), usuario.getPerfil(), token);
    }


    @ExceptionHandler({ AuthException.class })
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
}
