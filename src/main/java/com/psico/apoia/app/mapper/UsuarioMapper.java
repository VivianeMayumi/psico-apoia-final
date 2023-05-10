package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity usuarioToUsuarioEntity(Usuario usuario);

    Usuario usuarioEntityToUsuario(UsuarioEntity usuarioEntity);

    UsuarioEntity usuarioToUsuarioEntity(@MappingTarget UsuarioEntity usuarioTarget, Usuario usuarioSource);

    List<Usuario> usuarioEntityToUsuario(List<UsuarioEntity> usuariosEntity);

}
