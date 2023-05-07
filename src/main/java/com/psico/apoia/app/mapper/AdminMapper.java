package com.psico.apoia.app.mapper;

import com.psico.apoia.app.common.Admin;
import com.psico.apoia.app.entity.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminEntity admintoAdminEntity(Admin admin);

}
