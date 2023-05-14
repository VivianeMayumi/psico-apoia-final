package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AgendaPsicologoRepository extends CrudRepository<AgendaPsicologoEntity, Integer> {

    List<AgendaPsicologoEntity> findByPsicologoIdAndDisponivel(Integer idPsicologo, Boolean disponivel);
}
