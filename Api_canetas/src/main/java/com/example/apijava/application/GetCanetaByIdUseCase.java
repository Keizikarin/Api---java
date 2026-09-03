package com.example.apijava.application;

import com.example.apijava.application.output.CanetaOutput;
import com.example.apijava.domain.CanetaId;
import com.example.apijava.domain.CanetaNotFoundException;
import com.example.apijava.domain.CanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GetCanetaByIdUseCase {

    private final CanetaRepository repository;

    public CanetaOutput execute(CanetaId id) {
        return repository.findById(id)
                .map(CanetaOutput::from)
                .orElseThrow(() -> new CanetaNotFoundException(id));
    }
}
