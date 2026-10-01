package com.faculdade.animaisapi.repository;

import com.faculdade.animaisapi.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {

}