package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer> {

    UsuarioEntity findByUsuario(String usuario);

}
