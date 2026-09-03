package com.example.apijava.domain;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Caneta {
    private final CanetaId id;
    private String nome;
    private String marca;
    private TipoCaneta tipo;
    private String cor;
    private String ponta;
    private double preco;
    private int estoque;

    public Caneta(String nome, String marca, TipoCaneta tipo, String cor, String ponta, double preco, int estoque) {
        validate(nome, marca, tipo, cor, ponta, preco, estoque);
        this.id = new CanetaId();
        this.nome = nome; this.marca = marca; this.tipo = tipo; this.cor = cor;
        this.ponta = ponta; this.preco = preco; this.estoque = estoque;
    }

    public Caneta(CanetaId id, String nome, String marca, TipoCaneta tipo, String cor, String ponta, double preco, int estoque) {
        Assert.notNull(id, "O identificador da caneta não pode ser nulo");
        validate(nome, marca, tipo, cor, ponta, preco, estoque);
        this.id = id;
        this.nome = nome; this.marca = marca; this.tipo = tipo; this.cor = cor;
        this.ponta = ponta; this.preco = preco; this.estoque = estoque;
    }

    public void update(String nome, String marca, TipoCaneta tipo, String cor, String ponta, double preco, int estoque) {
        validate(nome, marca, tipo, cor, ponta, preco, estoque);
        this.nome = nome; this.marca = marca; this.tipo = tipo; this.cor = cor;
        this.ponta = ponta; this.preco = preco; this.estoque = estoque;
    }

    private static void validate(String nome, String marca, TipoCaneta tipo, String cor, String ponta, double preco, int estoque) {
        Assert.hasText(nome, "O nome não pode estar vazio");
        Assert.isTrue(nome.length() >= 2 && nome.length() <= 150, "O nome deve possuir entre 2 e 150 caracteres");
        Assert.hasText(marca, "A marca é obrigatória");
        Assert.isTrue(marca.length() <= 100, "A marca deve possuir no máximo 100 caracteres");
        Assert.notNull(tipo, "O tipo da caneta não pode ser nulo");
        Assert.hasText(cor, "A cor é obrigatória");
        Assert.hasText(ponta, "A ponta é obrigatória");
        Assert.isTrue(preco >= 0, "O preço não pode ser negativo");
        Assert.isTrue(Double.isFinite(preco), "O preço deve ser válido");
        Assert.isTrue(estoque >= 0, "O estoque não pode ser negativo");
    }
}
