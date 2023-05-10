package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.entity.PsicologoEntity;

import java.util.List;

public interface IPsicologoService {

    Psicologo criarPsicologo(Psicologo psicologo);

    List<Psicologo> obterPsicologoPorNome(String nome);

    //void deletarPsicologo(Integer idPsicologo);
    //public Psicologo atualizarPsicologo(Psicologo psicologo);
    //List<PsicologoEntity> buscarPorNome(String nome);
}

