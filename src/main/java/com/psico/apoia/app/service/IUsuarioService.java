package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Usuario;

public interface IUsuarioService {

    public boolean validarUsuario(String usuario, String senha);

    public Usuario criarUsuario(String usuario, String senha, String senhaConfirmacao);

    public void alterarSenha(String usuario, String senhaAntiga, String senhaNova);

}
