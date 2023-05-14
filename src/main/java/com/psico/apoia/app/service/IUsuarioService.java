package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Usuario;

public interface IUsuarioService {

    public boolean validarUsuario(String usuario, String senha);

    public Usuario obterUsuario(String usuario);

    public Usuario criarUsuario(String usuario, String senha, String senhaConfirmacao);

    public void alterarSenha(String email, String senhaAntiga, String senhaNova, String senhaNovaConfirmacao);

    public void deletarUsuario(String usuario);
}
