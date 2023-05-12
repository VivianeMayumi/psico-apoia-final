package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
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
    public AgendaPsicologoEntity criarAgendaComDiasDoMes(int mes, int ano, PsicologoEntity psicologo) {
        LocalDate dataInicial = LocalDate.of(ano, mes, 1);
        LocalDate dataFinal = dataInicial.withDayOfMonth(dataInicial.lengthOfMonth());
        AgendaPsicologoEntity agenda = new AgendaPsicologoEntity();
        agenda.setPsicologo(psicologo);
        agenda.setStatusDoAgendamento(true);
        List<LocalDate> datasDisponiveis = new ArrayList<>();
        for (LocalDate data = dataInicial; !data.isAfter(dataFinal); data = data.plusDays(1)) {
            datasDisponiveis.add(data);
        }
        agenda.setDataDisponivel(datasDisponiveis);
        return agenda;
    }

    @Override
    public List<LocalDate> buscarAgendaDisponivel(int mes, int ano, PsicologoEntity psicologo) {

        AgendaPsicologoEntity agenda = agendaPsicologoRepository.findByMesAndAnoAndPsicologo(mes, ano, psicologo);
            return agenda.getDataDisponivel();


    }

    @Override
    public void agendarSessao(Paciente paciente, LocalDate data, LocalDateTime horario) {

    }

    @Override
    public void cancelarAgendamento(AgendaPsicologo agendaPsicologo) {

    }
}
