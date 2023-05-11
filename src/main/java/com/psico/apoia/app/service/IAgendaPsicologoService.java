package com.psico.apoia.app.service;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAgendaPsicologoService {

    List<AgendaPsicologoEntity> buscarAgendaDisponível(LocalDate dataInicial, LocalDate dataFinal);

    void agendarSessao(Paciente paciente, LocalDate data, LocalDateTime horario);

    void cancelarAgendamento(AgendaPsicologo agendaPsicologo);


}
