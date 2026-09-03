package com.example.apijava.infrastructure.persistence.repository;
import com.example.apijava.infrastructure.persistence.entity.CanetaEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;
public interface CanetaCrudRepository extends CrudRepository<CanetaEntity,UUID>{}
