package com.example.apijava.application.input;
import com.example.apijava.domain.TipoCaneta;
public record CreateCanetaInput(String nome, String marca, TipoCaneta tipo, String cor, String ponta, double preco, int estoque) {}
