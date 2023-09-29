package br.com.exaltasamba.enterprisechallenge.presentation.login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    private static final byte[] SECRET_KEY_BYTES = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();

    public static String generateToken(String username) {
        Instant now = Instant.now();
        Instant expiryInstant = now.plus(1, ChronoUnit.HOURS);

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(java.util.Date.from(now))
                .setExpiration(java.util.Date.from(expiryInstant))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY_BYTES), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        JwtParser jwtParser =
                Jwts.parserBuilder()
                        .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY_BYTES))
                        .build();

        Claims claims = jwtParser.parseClaimsJws(token).getBody();
        return claims.get("username", String.class);
    }
}