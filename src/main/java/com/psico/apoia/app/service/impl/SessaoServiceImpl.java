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
import com.psico.apoia.app.service.ISessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessaoServiceImpl implements ISessaoService {

    @Autowired
    private AgendaPsicologoRepository agendaPsicologoRepository;

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Autowired
    private AgendaPsicologoMapper agendaPsicologoMapper;
    @Override
    public List<AgendaPsicologo> obterSessoesPsicologo(Integer idPsicologo) {
        List<AgendaPsicologoEntity> agendaPsicologoEntities = agendaPsicologoRepository.findByPsicologoId(idPsicologo);
        return agendaPsicologoMapper.agendaPsicologoEntityToAgendaPsicologo(agendaPsicologoEntities);
    }

    @Override
    public void confirmarSessao(Integer idAgendaPsicologo, String link) {
        Optional<AgendaPsicologoEntity> optionalAgendaPsicologoEntity = agendaPsicologoRepository.findById(idAgendaPsicologo);
        optionalAgendaPsicologoEntity.ifPresent(agendaPsicologoEntity -> {
            agendaPsicologoEntity.setStatus(StatusEnum.CONFIRMADA.getDescricao());
            agendaPsicologoEntity.setLink(link);
            agendaPsicologoRepository.save(agendaPsicologoEntity);
        });
    }

    @Override
    public void cancelarSessao(Integer idAgendaPsicologo) {
        Optional<AgendaPsicologoEntity> optionalAgendaPsicologoEntity = agendaPsicologoRepository.findById(idAgendaPsicologo);
        optionalAgendaPsicologoEntity.ifPresent(agendaPsicologoEntity -> {
            agendaPsicologoRepository.delete(agendaPsicologoEntity);
        });
    }

    @Override
    public void cadastrarNovaSessao(Integer idPsicologo, LocalDateTime dataHora) {
        AgendaPsicologoEntity newAgendaPsicologoEntity = new AgendaPsicologoEntity();
        newAgendaPsicologoEntity.setDisponivel(true);
        newAgendaPsicologoEntity.setDataHora(dataHora);

        Optional<PsicologoEntity> optionalPsicologoEntity = psicologoRepository.findById(idPsicologo);
        optionalPsicologoEntity.ifPresent(newAgendaPsicologoEntity::setPsicologo);
        agendaPsicologoRepository.save(newAgendaPsicologoEntity);
    }
}
