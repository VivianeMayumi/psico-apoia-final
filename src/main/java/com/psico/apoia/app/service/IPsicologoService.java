package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Psicologo;

import java.util.List;

public interface IPsicologoService {

    public Psicologo criarPsicologo(Psicologo psicologo);

    public List<Psicologo> obterPsicologoPorNome(String nome);

    public Psicologo atualizarPsicologo(Psicologo psicologo);

    public void deletarPsicologo(Integer idPsicologo);
}
