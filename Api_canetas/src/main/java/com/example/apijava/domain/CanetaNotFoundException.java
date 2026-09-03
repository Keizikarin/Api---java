package com.example.apijava.domain;

public class CanetaNotFoundException extends RuntimeException {

    public CanetaNotFoundException(CanetaId canetaId) {
        super("Caneta com identificador " + canetaId.id() + " não encontrada");
    }
}
