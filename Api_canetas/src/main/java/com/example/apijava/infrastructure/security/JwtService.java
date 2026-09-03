package com.example.apijava.infrastructure.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey chave;
    private final long expiracaoMinutos;

    public JwtService(SecurityProperties propriedades) {
        this.chave = Keys.hmacShaKeyFor(propriedades.jwt().secret().getBytes(StandardCharsets.UTF_8));
        this.expiracaoMinutos = propriedades.jwt().expirationMinutes();
    }

    public String gerarToken(String usuario) {
        Instant agora = Instant.now();
        return Jwts.builder()
                .subject(usuario)
                .issuedAt(Date.from(agora))
                .expiration(Date.from(agora.plus(expiracaoMinutos, ChronoUnit.MINUTES)))
                .signWith(chave)
                .compact();
    }

    /**
     * Valida a assinatura e a expiração e devolve o usuário (subject).
     * Lança {@link io.jsonwebtoken.JwtException} se o token for inválido.
     */
    public String extrairUsuario(String token) {
        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public long expiracaoEmSegundos() {
        return expiracaoMinutos * 60;
    }
}
