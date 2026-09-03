package com.example.apijava.infrastructure.persistence.entity;
import com.example.apijava.domain.TipoCaneta;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity @Table(name="canetas") @Getter @NoArgsConstructor(access=AccessLevel.PROTECTED)
public class CanetaEntity {
 @Id private UUID id;
 @Column(nullable=false,length=150) private String nome;
 @Column(nullable=false,length=100) private String marca;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=30) private TipoCaneta tipo;
 @Column(nullable=false,length=80) private String cor;
 @Column(nullable=false,length=50) private String ponta;
 @Column(nullable=false) private double preco;
 @Column(nullable=false) private int estoque;
 public CanetaEntity(UUID id,String nome,String marca,TipoCaneta tipo,String cor,String ponta,double preco,int estoque){
  this.id=id;this.nome=nome;this.marca=marca;this.tipo=tipo;this.cor=cor;this.ponta=ponta;this.preco=preco;this.estoque=estoque;
 }
}
