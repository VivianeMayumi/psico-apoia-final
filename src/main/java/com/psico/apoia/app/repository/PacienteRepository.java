package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends CrudRepository<PacienteEntity, Integer> {

    List<PacienteEntity> findByNomeContainingIgnoreCase(String nome);
}
