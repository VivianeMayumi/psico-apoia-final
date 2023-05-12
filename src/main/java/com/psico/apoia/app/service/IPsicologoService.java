package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Psicologo;

import com.psico.apoia.app.entity.PsicologoEntity;

import java.util.List;

public interface IPsicologoService {

    Psicologo criarPsicologo(Psicologo psicologo);

    public Psicologo obterPsicologoPorId(Integer id);

    List<Psicologo> obterPsicologoPorNome(String nome);

    Iterable<PsicologoEntity> obterTodosOsPsicologos();



    //void deletarPsicologo(Integer idPsicologo);
    //public Psicologo atualizarPsicologo(Psicologo psicologo);

}

