package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface AgendaPsicologoRepository extends CrudRepository<AgendaPsicologoEntity, LocalDate> {

    List<AgendaPsicologoEntity> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    AgendaPsicologoEntity findByMesAndAnoAndPsicologo(int mes, int ano, PsicologoEntity psicologo);
}
