package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.AgendamentoEntity;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.enums.StatusEnum;
import com.psico.apoia.app.mapper.AgendaPsicologoMapper;
import com.psico.apoia.app.mapper.AgendamentoMapper;
import com.psico.apoia.app.repository.AgendaPsicologoRepository;
import com.psico.apoia.app.repository.AgendamentoRepository;
import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.service.IAgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private AgendamentoMapper agendamentoMapper;

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
    //validar agendamento de sessão
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
            agendaPsicologoEntity.setStatus(StatusEnum.A_CONFIRMAR.getDescricao());
            agendaPsicologoRepository.save(agendaPsicologoEntity);
        });
    }

    @Override
    @Transactional
    public void cancelarAgendamento(Integer idAgendamento) {
        Optional<AgendamentoEntity> optionalAgendamentoEntity = agendamentoRepository.findById(idAgendamento);
        optionalAgendamentoEntity.ifPresent(agendamentoEntity -> {

            Optional<AgendaPsicologoEntity> optionalAgendaPsicologoEntity = agendaPsicologoRepository.findById(agendamentoEntity.getAgendaPsicologoEntity().getId());
            optionalAgendaPsicologoEntity.ifPresent(agendaPsicologoEntity -> {
                agendaPsicologoEntity.setStatus(StatusEnum.DISPONIVEL.getDescricao());
                agendaPsicologoEntity.setDisponivel(true);
                agendaPsicologoEntity.setLink(null);
                agendaPsicologoEntity.setAgendamento(null);
                agendaPsicologoRepository.save(agendaPsicologoEntity);
            });

            agendamentoEntity.setPaciente(null);
            agendamentoEntity.setAgendaPsicologoEntity(null);
            agendamentoRepository.delete(agendamentoEntity);
        });
    }

    @Override
    public List<Agendamento> obterAgendamentosPaciente(Integer idPaciente) {
        List<AgendamentoEntity> agendamentoEntityList = agendamentoRepository.buscarPorPacienteId(idPaciente);
        return agendamentoMapper.agendamentoEntityToAgendamento(agendamentoEntityList);
    }
}
