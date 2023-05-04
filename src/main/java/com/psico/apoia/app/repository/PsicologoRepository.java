package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PsicologoRepository extends CrudRepository<PsicologoEntity, Integer> {
    List<PsicologoEntity> findByNomeContainingIgnoreCase(String nome);
}
