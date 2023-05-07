package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Admin;
import com.psico.apoia.app.entity.AdminEntity;
import com.psico.apoia.app.mapper.AdminMapper;
import com.psico.apoia.app.repository.AdminRepository;
import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Override
    public Admin criarAdmin(Admin admin) {
        AdminEntity adminEntity = AdminMapper.INSTANCE.adminToAdminEntity(admin);
        adminRepository.save(adminEntity);
        return AdminMapper.INSTANCE.adminEntityToAdmin(adminEntity);
    }

    @Override
    public Admin atualizarAdmin(Admin admin) {
        Optional<AdminEntity> adminOptionalBancoDeDados = adminRepository.findById(admin.getEmail());
        return adminOptionalBancoDeDados.map(adminEntityBancoDeDados -> {
            adminEntityBancoDeDados.setNome(admin.getNome());
            adminEntityBancoDeDados.setEmail(admin.getEmail());
            adminEntityBancoDeDados.setCpf(admin.getCpf());
            return AdminMapper.INSTANCE.adminEntityToAdmin(adminRepository.save(adminEntityBancoDeDados));
        }).orElse(null);
    }

    @Override
    public void deletarAdmin(String email) {
        adminRepository.deleteById(email);
    }

    @Override
    public List<Admin> obterAdminPorEmail(String email) {
        List<AdminEntity> listaAdmin = adminRepository.findByEmail(email);
        return AdminMapper.INSTANCE.adminEntityToAdmin(listaAdmin);
    }

    @Override
    public List<Admin> obterAdminPorNome(String nome) {
        List<AdminEntity> listaAdmin = adminRepository.findByEmail(nome);
        return AdminMapper.INSTANCE.adminEntityToAdmin(listaAdmin);
    }


    // TODO métodos de gerenciamento dos psicólogos e pacientes

}
