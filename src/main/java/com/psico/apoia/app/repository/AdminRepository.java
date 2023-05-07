package com.psico.apoia.app.repository;

import com.psico.apoia.app.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<AdminEntity, String> {

    List<AdminEntity> findByEmail(String email);

}
