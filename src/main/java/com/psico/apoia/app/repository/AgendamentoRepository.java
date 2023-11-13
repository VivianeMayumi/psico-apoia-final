package com.psico.apoia.app.repository;

import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AgendamentoRepository extends CrudRepository<AgendamentoEntity, Integer> {

    @Query(
        " SELECT agendamento FROM AgendamentoEntity agendamento " +
        " JOIN FETCH agendamento.paciente paciente " +
        " JOIN FETCH agendamento.agendaPsicologoEntity agendaPsicologo " +
        " WHERE agendamento.paciente.id = :idPaciente")
    List<AgendamentoEntity> buscarPorPacienteId(Integer idPaciente);

    @Query(
        " SELECT agendamento FROM AgendamentoEntity agendamento " +
        " JOIN FETCH agendamento.paciente paciente " +
        " JOIN FETCH agendamento.agendaPsicologoEntity agendaPsicologo " +
        " WHERE agendamento.id = :id")
    AgendamentoEntity buscarPorId(Integer id);
}
