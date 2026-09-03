package com.example.apijava.application;

import com.example.apijava.domain.CanetaId;
import com.example.apijava.domain.CanetaNotFoundException;
import com.example.apijava.domain.CanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeleteCanetaUseCase {

    private final CanetaRepository repository;

    public void execute(CanetaId id) {
        if (repository.findById(id).isEmpty()) {
            throw new CanetaNotFoundException(id);
        }

        repository.delete(id);
    }
}
