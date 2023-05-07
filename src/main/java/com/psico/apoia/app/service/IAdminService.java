package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Admin;

import java.util.List;

public interface IAdminService {
    // TODO inserir os métodos necessários p/ gerenciamento de psicólogos e pacientes

    public Admin criarAdmin(Admin admin);

    public Admin atualizarAdmin(Admin admin);

    public void deletarAdmin(String email);

    public List<Admin> obterAdminPorEmail(String email);

    public List<Admin> obterAdminPorNome(String nome);

}
