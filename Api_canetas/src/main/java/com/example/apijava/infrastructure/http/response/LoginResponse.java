package com.example.apijava.infrastructure.http.response;

public record LoginResponse(String token, String tipo, long expiraEmSegundos) {

    public static LoginResponse bearer(String token, long expiraEmSegundos) {
        return new LoginResponse(token, "Bearer", expiraEmSegundos);
    }
}
