package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.PalestraEntity;
import com.psico.apoia.app.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalestraRepository extends CrudRepository<PalestraEntity, Integer> {

}
