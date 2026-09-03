package com.example.apijava.infrastructure.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mapeia o bloco {@code app.security} do application.properties.
 */
@ConfigurationProperties(prefix = "app.security")
public record SecurityProperties(String usuario, String senha, Jwt jwt) {

    public record Jwt(String secret, long expirationMinutes) {
    }
}
