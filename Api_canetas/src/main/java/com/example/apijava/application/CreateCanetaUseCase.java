package com.example.apijava.application;

import com.example.apijava.application.input.CreateCanetaInput;
import com.example.apijava.application.output.CanetaOutput;
import com.example.apijava.domain.Caneta;
import com.example.apijava.domain.CanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateCanetaUseCase {

    private final CanetaRepository repository;

    public CanetaOutput execute(CreateCanetaInput input) {
        var caneta = new Caneta(
                input.nome(),
                input.marca(),
                input.tipo(),
                input.cor(),
                input.ponta(),
                input.preco(),
                input.estoque()
        );

        var saved = repository.save(caneta);

        return CanetaOutput.from(saved);
    }
}
