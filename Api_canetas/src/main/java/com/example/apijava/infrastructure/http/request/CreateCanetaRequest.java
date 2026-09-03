package com.example.apijava.infrastructure.http.request;
import com.example.apijava.application.input.CreateCanetaInput;
import com.example.apijava.domain.TipoCaneta;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCanetaRequest(
 @NotBlank(message="O nome é obrigatório") @Size(min=2,max=150,message="O nome deve possuir entre 2 e 150 caracteres") String nome,
 @NotBlank(message="A marca é obrigatória") @Size(max=100,message="A marca deve possuir no máximo 100 caracteres") String marca,
 @NotNull(message="O tipo é obrigatório") TipoCaneta tipo,
 @NotBlank(message="A cor é obrigatória") String cor,
 @NotBlank(message="A ponta é obrigatória") String ponta,
 @DecimalMin(value="0.0",message="O preço não pode ser negativo") double preco,
 @Min(value=0,message="O estoque não pode ser negativo") int estoque
) {
 public CreateCanetaInput toInput(){ return new CreateCanetaInput(nome,marca,tipo,cor,ponta,preco,estoque); }
}
