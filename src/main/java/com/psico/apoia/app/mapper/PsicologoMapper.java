package com.psico.apoia.app.mapper;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.common.Psicologo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PsicologoMapper {

    PsicologoMapper INSTANCE = Mappers.getMapper(PsicologoMapper.class);


    PsicologoEntity psicologToPsicologoEntity(Psicologo psicologo);

    Psicologo psicologoEntityToPsicologo(PsicologoEntity psicologo);

    List<Psicologo> psicologoEntityToPsicologo(List<PsicologoEntity> psicologosEntity);
}
