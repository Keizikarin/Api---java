package com.example.apijava.infrastructure.http;

import com.example.apijava.infrastructure.http.request.LoginRequest;
import com.example.apijava.infrastructure.http.response.LoginResponse;
import com.example.apijava.infrastructure.security.JwtService;
import com.example.apijava.infrastructure.security.SecurityProperties;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SecurityProperties properties;
    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        var authenticated = properties.usuario().equals(request.usuario())
                && properties.senha().equals(request.senha());

        if (!authenticated) {
            throw new BadCredentialsException("Usuário ou senha inválidos");
        }

        var token = jwtService.gerarToken(request.usuario());

        return LoginResponse.bearer(token, jwtService.expiracaoEmSegundos());
    }
}
