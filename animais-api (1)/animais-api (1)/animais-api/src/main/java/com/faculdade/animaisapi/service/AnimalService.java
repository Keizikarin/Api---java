package com.faculdade.animaisapi.service;

import com.faculdade.animaisapi.model.Animal;
import com.faculdade.animaisapi.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import com.faculdade.animaisapi.exception.AnimalNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {


    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal cadastrar(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Optional<Animal> buscarPorId(UUID id) {
        return animalRepository.findById(id);
    }

    public Animal atualizar(UUID id, Animal animalAtualizado) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(AnimalNotFoundException::new);

        animal.setNome(animalAtualizado.getNome());
        animal.setEspecie(animalAtualizado.getEspecie());
        animal.setRaca(animalAtualizado.getRaca());
        animal.setIdade(animalAtualizado.getIdade());
        animal.setSexo(animalAtualizado.getSexo());
        animal.setDisponivelParaAdocao(animalAtualizado.getDisponivelParaAdocao());

        return animalRepository.save(animal);
    }

    public void excluir(UUID id) {
        if (!animalRepository.existsById(id)) {
            throw new AnimalNotFoundException();
        }

        animalRepository.deleteById(id);
    }
}
