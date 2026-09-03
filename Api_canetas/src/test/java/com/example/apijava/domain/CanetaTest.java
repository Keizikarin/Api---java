package com.example.apijava.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CanetaTest {
 @Test void deveCriarCaneta(){ var c=new Caneta("Caneta Gel","Pentel",TipoCaneta.GEL,"Azul","0.7 mm",8.9,10); assertNotNull(c.getId()); assertEquals(TipoCaneta.GEL,c.getTipo()); }
 @Test void naoPermitePrecoNegativo(){ assertThrows(IllegalArgumentException.class,()->new Caneta("Caneta","BIC",TipoCaneta.ESFEROGRAFICA,"Azul","1.0 mm",-1,1)); }
}
