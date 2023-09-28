package br.com.exaltasamba.enterprisechallenge.domain.auth;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
