package com.psico.apoia.app.mapper;

import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.common.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteEntity pacienteToPacienteEntity(Paciente paciente);

    Paciente pacienteEntityToPaciente(PacienteEntity paciente);

    List<Paciente> pacienteEntityToPaciente(List<PacienteEntity> pacientesEntity);
}
