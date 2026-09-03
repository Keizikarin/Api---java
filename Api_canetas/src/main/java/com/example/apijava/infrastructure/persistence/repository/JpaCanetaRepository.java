package com.example.apijava.infrastructure.persistence.repository;
import com.example.apijava.domain.*;
import com.example.apijava.infrastructure.persistence.entity.CanetaEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@AllArgsConstructor @Repository
public class JpaCanetaRepository implements CanetaRepository {
 private final CanetaCrudRepository repository;
 public Caneta save(Caneta c){return toDomain(repository.save(toEntity(c)));}
 public List<Caneta> findAll(){return StreamSupport.stream(repository.findAll().spliterator(),false).map(this::toDomain).toList();}
 public Optional<Caneta> findById(CanetaId id){return repository.findById(id.id()).map(this::toDomain);}
 public void delete(CanetaId id){repository.deleteById(id.id());}
 private CanetaEntity toEntity(Caneta c){return new CanetaEntity(c.getId().id(),c.getNome(),c.getMarca(),c.getTipo(),c.getCor(),c.getPonta(),c.getPreco(),c.getEstoque());}
 private Caneta toDomain(CanetaEntity e){return new Caneta(new CanetaId(e.getId()),e.getNome(),e.getMarca(),e.getTipo(),e.getCor(),e.getPonta(),e.getPreco(),e.getEstoque());}
}
