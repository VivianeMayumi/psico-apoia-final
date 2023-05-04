package com.psico.apoia.app.mapper;

import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.common.Psicologo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PsicologoMapper {

    PsicologoMapper INSTANCE = Mappers.getMapper(PsicologoMapper.class);

    PsicologoEntity psicologoToPsicologoEntity(Psicologo psicologo);
}
