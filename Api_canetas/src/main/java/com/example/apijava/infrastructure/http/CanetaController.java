package com.example.apijava.infrastructure.http;

import com.example.apijava.application.CreateCanetaUseCase;
import com.example.apijava.application.DeleteCanetaUseCase;
import com.example.apijava.application.GetCanetaByIdUseCase;
import com.example.apijava.application.ListCanetasUseCase;
import com.example.apijava.application.UpdateCanetaUseCase;
import com.example.apijava.domain.CanetaId;
import com.example.apijava.infrastructure.http.request.CreateCanetaRequest;
import com.example.apijava.infrastructure.http.request.UpdateCanetaRequest;
import com.example.apijava.infrastructure.http.response.CanetaResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/canetas")
public class CanetaController {

    private final CreateCanetaUseCase createCanetaUseCase;
    private final ListCanetasUseCase listCanetasUseCase;
    private final GetCanetaByIdUseCase getCanetaByIdUseCase;
    private final UpdateCanetaUseCase updateCanetaUseCase;
    private final DeleteCanetaUseCase deleteCanetaUseCase;

    @PostMapping
    public ResponseEntity<CanetaResponse> create(
            @RequestBody @Valid CreateCanetaRequest request
    ) {
        var input = request.toInput();

        var output = createCanetaUseCase.execute(input);

        var response = CanetaResponse.from(output);

        var location = URI.create("/canetas/" + output.id());

        return ResponseEntity
                .created(location)
                .body(response);
    }

    @GetMapping
    public List<CanetaResponse> list() {
        return listCanetasUseCase.execute()
                .stream()
                .map(CanetaResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public CanetaResponse getById(@PathVariable UUID id) {
        var output = getCanetaByIdUseCase.execute(
                new CanetaId(id)
        );

        return CanetaResponse.from(output);
    }

    @PutMapping("/{id}")
    public CanetaResponse update(
            @PathVariable UUID id,
            @RequestBody @Valid UpdateCanetaRequest request
    ) {
        var input = request.toInput();

        var output = updateCanetaUseCase.execute(
                new CanetaId(id),
                input
        );

        return CanetaResponse.from(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteCanetaUseCase.execute(
                new CanetaId(id)
        );

        return ResponseEntity.noContent().build();
    }
}
