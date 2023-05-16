package com.psico.apoia.app.repository;

import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.AgendamentoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AgendamentoRepository extends CrudRepository<AgendamentoEntity, Integer> {
}
