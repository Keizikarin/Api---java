package com.example.apijava.infrastructure.http.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank(message = "O usuário é obrigatório")
        String usuario,

        @NotBlank(message = "A senha é obrigatória")
        String senha
) {
}
