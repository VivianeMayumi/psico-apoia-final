package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Admin;
import com.psico.apoia.app.entity.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminEntity adminToAdminEntity(Admin admin);

    Admin adminEntityToAdmin(AdminEntity admin);

    List<Admin> adminEntityToAdmin(List<AdminEntity> adminsList);
}
