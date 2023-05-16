package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaPsicologoMapper {

    AgendaPsicologoEntity agendaPsicologoToAgendaPsicologoEntity(AgendaPsicologo agendaPsicologo);

    AgendaPsicologoEntity agendaPsicologoToAgendaPsicologoEntity(@MappingTarget AgendaPsicologoEntity AgendaPsicologoTarget, AgendaPsicologo agendaPsicologoSource);

    AgendaPsicologo agendaPsicologoEntityToAgendaPsicologo(AgendaPsicologoEntity agendaPsicologo);

    List<AgendaPsicologo> agendaPsicologoEntityToAgendaPsicologo (List<AgendaPsicologoEntity> agendaPsicologoEntity);
}
