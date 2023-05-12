package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.repository.AgendaPsicologoRepository;
import com.psico.apoia.app.service.IAgendaPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaPsicologoServiceImpl implements IAgendaPsicologoService {


    @Autowired
    private AgendaPsicologoRepository agendaPsicologoRepository;


    @Override
    public List<AgendaPsicologoEntity> buscarAgendaDisponível(LocalDate dataInicio, LocalDate dataFim) {
        List<AgendaPsicologoEntity> agendas = agendaPsicologoRepository.findByDataBetween(dataInicio, dataFim);
        List<AgendaPsicologoEntity> agendasDisponiveis = new ArrayList<>();

        for(AgendaPsicologoEntity agenda : agendas){
            if(agenda.isStatusDoAgendamento() == true){
                agendasDisponiveis.add(agenda);
            }
        }
        return agendasDisponiveis;
    }

    @Override
    public void agendarSessao(Paciente paciente, LocalDate data, LocalDateTime horario) {

    }

    @Override
    public void cancelarAgendamento(AgendaPsicologo agendaPsicologo) {

    }
}
