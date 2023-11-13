package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Usuario;

public interface IUsuarioService {

    public boolean validarUsuario(String usuario, String senha);

    public Usuario obterUsuario(String usuario);

    public Usuario criarUsuario(Usuario usuario);

    public void alterarSenha(Integer id, String senhaAntiga, String senhaNova, String senhaNovaConfirmacao);

    public void deletarUsuario(String usuario);

    public Usuario alterarUsuario(Usuario usuario);
}
