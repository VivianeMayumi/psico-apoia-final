package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.AgendamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaPsicologoMapper {

    AgendaPsicologoEntity agendaPsicologoToAgendaPsicologoEntity(AgendaPsicologo agendaPsicologo);

    AgendaPsicologoEntity agendaPsicologoToAgendaPsicologoEntity(@MappingTarget AgendaPsicologoEntity AgendaPsicologoTarget, AgendaPsicologo agendaPsicologoSource);

    @Mapping(source = "agendamento.paciente.nome", target = "paciente.nome")
    AgendaPsicologo agendaPsicologoEntityToAgendaPsicologo(AgendaPsicologoEntity agendaPsicologoEntity);

    List<AgendaPsicologo> agendaPsicologoEntityToAgendaPsicologo (List<AgendaPsicologoEntity> agendaPsicologoEntity);
}
