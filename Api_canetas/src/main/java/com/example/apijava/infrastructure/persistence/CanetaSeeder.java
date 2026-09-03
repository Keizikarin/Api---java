package com.example.apijava.infrastructure.persistence;
import com.example.apijava.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component @AllArgsConstructor
public class CanetaSeeder implements CommandLineRunner {
 private final CanetaRepository repository;
 @Override public void run(String... args){
  if(!repository.findAll().isEmpty()) return;
  var iniciais=List.of(
   new Caneta("Caneta Bic Cristal","BIC",TipoCaneta.ESFEROGRAFICA,"Azul","1.0 mm",2.50,100),
   new Caneta("Caneta Gel","Pentel",TipoCaneta.GEL,"Preta","0.7 mm",8.90,50),
   new Caneta("Caneta Hidrográfica","Faber-Castell",TipoCaneta.HIDROGRAFICA,"Vermelha","2.0 mm",5.50,40),
   new Caneta("Marca-texto","Stabilo",TipoCaneta.MARCA_TEXTO,"Amarelo","2.0-5.0 mm",7.90,30)
  );
  iniciais.forEach(repository::save);
 }
}
