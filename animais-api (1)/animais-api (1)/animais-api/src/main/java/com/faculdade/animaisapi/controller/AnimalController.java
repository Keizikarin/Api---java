package com.faculdade.animaisapi.controller;

import com.faculdade.animaisapi.model.Animal;
import com.faculdade.animaisapi.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public Animal cadastrar(@Valid @RequestBody Animal animal) {
        return animalService.cadastrar(animal);
    }
    @GetMapping
    public List<Animal> listarTodos() {
        return animalService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable UUID id) {
        return animalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Animal atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody Animal animal) {

        return animalService.atualizar(id, animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable UUID id) {
        animalService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}