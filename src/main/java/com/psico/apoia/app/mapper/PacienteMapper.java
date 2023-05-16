package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.entity.PacienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface PacienteMapper {

    PacienteEntity pacienteToPacienteEntity(Paciente paciente);

    PacienteEntity pacienteToPacienteEntity(@MappingTarget PacienteEntity pacienteTarget, Paciente pacienteSource);

    Paciente pacienteEntityToPaciente(PacienteEntity paciente);

    @Mapping(ignore = true, source = "usuario", target = "usuario")
    Usuario pacienteEntityToUsuario(PacienteEntity paciente);



    List<Paciente> pacienteEntityToPaciente(List<PacienteEntity> pacientesEntity);
}
