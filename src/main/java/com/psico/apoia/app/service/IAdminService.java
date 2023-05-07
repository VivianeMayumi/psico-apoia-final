package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Admin;

public interface IAdminService extends IPacienteService {
    // TODO extender a interface service de psicólogo ou inserir os métodos necessários

    public Admin criarAdmin(Admin admin);

    public Admin atualizarAdmin(Admin admin);

}
