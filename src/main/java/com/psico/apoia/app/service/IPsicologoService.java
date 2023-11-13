package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Psicologo;

import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.exception.PsicologoNaoEncontradoException;

import java.util.List;

public interface IPsicologoService {

    Psicologo criarPsicologo(Psicologo psicologo);

    public Psicologo obterPsicologoPorId(Integer id);

    public Iterable<Psicologo> obterPsicologoPorNome(String nome) throws PsicologoNaoEncontradoException;

    public Iterable<Psicologo> obterTodosPsicologos();

    public Psicologo obterPsicologoPorIdUsuario(Integer idUsuario);
}

