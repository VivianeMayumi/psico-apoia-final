package com.psico.apoia.app.mapper;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.common.Psicologo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface PsicologoMapper {


    PsicologoEntity psicologoToPsicologoEntity(Psicologo psicologo);

    PsicologoEntity psicologoToPsicologoEntity(@MappingTarget PsicologoEntity psicologoTarget, Psicologo psicologoSource);

    Psicologo psicologoEntityToPsicologo(PsicologoEntity psicologo);

    List<Psicologo> psicologoEntityToPsicologo(List<PsicologoEntity> psicologosEntity);
}

