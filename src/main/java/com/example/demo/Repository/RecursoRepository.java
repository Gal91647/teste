package com.example.demo.Repository;


import com.example.demo.Entity.Recurso;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecursoRepository extends BaseRepository<Recurso, Long> {

    @Query("SELECT u FROM Recurso u WHERE u.nome = :nome")
    List<Recurso> findByTipo(String nome);

    @Query("SELECT u FROM Recurso u WHERE u.id = :id")
    Recurso findById(String id);
}