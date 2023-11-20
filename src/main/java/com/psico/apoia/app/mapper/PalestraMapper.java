package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Palestra;
import com.psico.apoia.app.entity.PalestraEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PalestraMapper {
    List<Palestra> palestraEntityToPalestra(List<PalestraEntity> palestrasEntity);
}
