package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.AgendamentoEntity;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.mapper.AgendaPsicologoMapper;
import com.psico.apoia.app.repository.AgendaPsicologoRepository;
import com.psico.apoia.app.repository.AgendamentoRepository;
import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.service.IAgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoServiceImpl implements IAgendamentoService {

    @Autowired
    private AgendaPsicologoRepository agendaPsicologoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private AgendaPsicologoMapper agendaPsicologoMapper;

    @Override
    public AgendaPsicologoEntity criarAgendaComDiasDoMes(int mes, int ano, PsicologoEntity psicologo) {
        LocalDate dataInicial = LocalDate.of(ano, mes, 1);
        LocalDate dataFinal = dataInicial.withDayOfMonth(dataInicial.lengthOfMonth());
        AgendaPsicologoEntity agenda = new AgendaPsicologoEntity();
        agenda.setPsicologo(psicologo);
//        agenda.setStatusDoAgendamento(true);
//        agenda.setData(dataInicial);
        List<LocalDate> datasDisponiveis = new ArrayList<>();
        for (LocalDate data = dataInicial; !data.isAfter(dataFinal); data = data.plusDays(1)) {
            datasDisponiveis.add(data);
        }
//        agenda.setDataDisponivel(datasDisponiveis);
        return agenda;
    }


    @Override
    public List<AgendaPsicologo> buscarAgendaDisponivel(Integer idPsicologo) {
        List<AgendaPsicologoEntity> agendasPsicologo = agendaPsicologoRepository.findByPsicologoIdAndDisponivel(idPsicologo, Boolean.TRUE);
        return agendaPsicologoMapper.agendaPsicologoEntityToAgendaPsicologo(agendasPsicologo);
    }

    @Override
    public void agendarSessao(Integer idPaciente, Integer idAgendaPsicologo) {
        Optional<PacienteEntity> optionalPacienteEntity = pacienteRepository.findById(idPaciente);
        Optional<AgendaPsicologoEntity> optionalAgendaPsicologoEntity = agendaPsicologoRepository.findById(idAgendaPsicologo);
        AgendamentoEntity agendamentoEntity = new AgendamentoEntity();
        agendamentoEntity.setCancelado(false);
        optionalPacienteEntity.ifPresent(agendamentoEntity::setPaciente);
        optionalAgendaPsicologoEntity.ifPresent(agendamentoEntity::setAgendaPsicologoEntity);
        agendamentoRepository.save(agendamentoEntity);
        optionalAgendaPsicologoEntity.ifPresent(agendaPsicologoEntity -> {
            agendaPsicologoEntity.setDisponivel(false);
            agendaPsicologoRepository.save(agendaPsicologoEntity);
        });
    }

    @Override
    public void cancelarAgendamento(AgendaPsicologo agendaPsicologo) {

    }
}
