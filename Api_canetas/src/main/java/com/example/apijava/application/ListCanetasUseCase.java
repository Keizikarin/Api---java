package com.example.apijava.application;

import com.example.apijava.application.output.CanetaOutput;
import com.example.apijava.domain.CanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListCanetasUseCase {

    private final CanetaRepository repository;

    public List<CanetaOutput> execute() {
        return repository.findAll()
                .stream()
                .map(CanetaOutput::from)
                .toList();
    }
}
