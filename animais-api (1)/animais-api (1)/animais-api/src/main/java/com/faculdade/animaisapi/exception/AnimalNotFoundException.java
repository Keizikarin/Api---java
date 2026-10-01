package com.faculdade.animaisapi.exception;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException() {
        super("Animal não encontrado");
    }
}