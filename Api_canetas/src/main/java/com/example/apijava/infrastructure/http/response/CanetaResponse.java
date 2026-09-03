package com.example.apijava.infrastructure.http.response;
import com.example.apijava.application.output.CanetaOutput;
import com.example.apijava.domain.TipoCaneta;
public record CanetaResponse(String id,String nome,String marca,TipoCaneta tipo,String cor,String ponta,double preco,int estoque){
 public static CanetaResponse from(CanetaOutput o){ return new CanetaResponse(o.id(),o.nome(),o.marca(),o.tipo(),o.cor(),o.ponta(),o.preco(),o.estoque()); }
}
