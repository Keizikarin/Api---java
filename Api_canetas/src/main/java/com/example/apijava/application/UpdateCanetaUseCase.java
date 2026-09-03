package com.example.apijava.application;

import com.example.apijava.application.input.UpdateCanetaInput;
import com.example.apijava.application.output.CanetaOutput;
import com.example.apijava.domain.CanetaId;
import com.example.apijava.domain.CanetaNotFoundException;
import com.example.apijava.domain.CanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UpdateCanetaUseCase {

    private final CanetaRepository repository;

    public CanetaOutput execute(CanetaId id, UpdateCanetaInput input) {
        var caneta = repository.findById(id)
                .orElseThrow(() -> new CanetaNotFoundException(id));

        caneta.update(
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
