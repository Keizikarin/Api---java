package com.example.apijava.domain;

import java.util.List;
import java.util.Optional;

public interface CanetaRepository {

    Caneta save(Caneta caneta);

    List<Caneta> findAll();

    Optional<Caneta> findById(CanetaId id);

    void delete(CanetaId id);
}
