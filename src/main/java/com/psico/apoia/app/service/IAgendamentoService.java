package com.psico.apoia.app.service;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;

import java.util.List;

public interface IAgendamentoService {

    AgendaPsicologoEntity criarAgendaComDiasDoMes(int mes, int ano, PsicologoEntity psicologo);

    public List<AgendaPsicologo> buscarAgendaDisponivel(Integer idPsicologo);
    void agendarSessao(Integer idPaciente, Integer idAgendaPsicologo);

    void cancelarAgendamento(AgendaPsicologo agendaPsicologo);


}
