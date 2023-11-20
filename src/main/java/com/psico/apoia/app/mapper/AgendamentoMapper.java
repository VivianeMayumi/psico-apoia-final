package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.entity.AgendamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {


    List<Agendamento> agendamentoEntityToAgendamento(List<AgendamentoEntity> agendamentoEntities);

    @Mapping(source = "agendaPsicologoEntity.dataHora", target = "dataHora")
    @Mapping(source = "agendaPsicologoEntity.psicologo.id", target = "idPsicologo")
    @Mapping(source = "agendaPsicologoEntity.psicologo.nome", target = "nomePsicologo")
    @Mapping(source = "agendaPsicologoEntity.status", target = "status")
    @Mapping(source = "agendaPsicologoEntity.link", target = "link")
    Agendamento agendamentoEntityToAgendamento(AgendamentoEntity agendamentoEntity);

}
