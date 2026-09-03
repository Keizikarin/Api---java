package com.example.apijava.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CanetaId(UUID id) {

    public CanetaId {
        Assert.notNull(id, "O identificador da caneta não pode ser nulo");
    }

    public CanetaId() {
        this(UUID.randomUUID());
    }
}
