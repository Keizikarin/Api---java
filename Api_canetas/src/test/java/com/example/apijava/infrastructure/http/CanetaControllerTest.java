package com.example.apijava.infrastructure.http;
import com.example.apijava.application.*;
import com.example.apijava.application.output.CanetaOutput;
import com.example.apijava.domain.TipoCaneta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(CanetaController.class)
class CanetaControllerTest {
 @Autowired MockMvc mockMvc;
 @MockitoBean CreateCanetaUseCase createCanetaUseCase;
 @MockitoBean ListCanetasUseCase listCanetasUseCase;
 @MockitoBean GetCanetaByIdUseCase getCanetaByIdUseCase;
 @MockitoBean UpdateCanetaUseCase updateCanetaUseCase;
 @MockitoBean DeleteCanetaUseCase deleteCanetaUseCase;
 @Test void deveListarCanetas() throws Exception {
  when(listCanetasUseCase.execute()).thenReturn(List.of(new CanetaOutput("1","Caneta Gel","Pentel",TipoCaneta.GEL,"Azul","0.7 mm",8.9,10)));
  mockMvc.perform(get("/canetas")).andExpect(status().isOk()).andExpect(jsonPath("$[0].nome").value("Caneta Gel")).andExpect(jsonPath("$[0].tipo").value("GEL"));
 }
}
