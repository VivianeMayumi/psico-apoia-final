package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Endereco;
import com.psico.apoia.app.entity.EnderecoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoEntity enderecoToEnderecoEntity(Endereco endereco);

    EnderecoEntity enderecoToEnderecoEntity(@MappingTarget EnderecoEntity enderecoEntityTarget, Endereco enderecoSource);

    Endereco enderecoEntityToEndereco(EnderecoEntity enderecoEntity);
}
