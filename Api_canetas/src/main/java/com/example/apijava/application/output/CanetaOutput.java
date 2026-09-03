package com.example.apijava.application.output;
import com.example.apijava.domain.Caneta;
import com.example.apijava.domain.TipoCaneta;
public record CanetaOutput(String id, String nome, String marca, TipoCaneta tipo, String cor, String ponta, double preco, int estoque) {
    public static CanetaOutput from(Caneta c) {
        return new CanetaOutput(c.getId().id().toString(), c.getNome(), c.getMarca(), c.getTipo(), c.getCor(), c.getPonta(), c.getPreco(), c.getEstoque());
    }
}
