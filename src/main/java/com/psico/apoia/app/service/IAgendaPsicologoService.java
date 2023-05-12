package com.psico.apoia.app.service;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IAgendaPsicologoService {

    AgendaPsicologoEntity criarAgendaComDiasDoMes(int mes, int ano, PsicologoEntity psicologo);

    //List<AgendaPsicologoEntity> buscarAgendaDisponivel(LocalDate dataInicial, LocalDate dataFinal);
    List<LocalDate> buscarAgendaDisponivel(int mes, int ano, PsicologoEntity psicologo);
    void agendarSessao(Paciente paciente, LocalDate data, LocalDateTime horario);

    void cancelarAgendamento(AgendaPsicologo agendaPsicologo);


}
