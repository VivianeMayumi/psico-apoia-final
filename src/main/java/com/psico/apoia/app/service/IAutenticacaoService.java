package com.psico.apoia.app.service;

public interface IAutenticacaoService {

    public boolean autenticar(String email, String senha);

    public void cadastrarLogin(String email, String senha);

    public void alterarSenha(String email, String senhaAntiga, String senhaNova);

}
