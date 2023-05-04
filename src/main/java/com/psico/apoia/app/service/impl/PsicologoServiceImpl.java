package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.mapper.PacienteMapper;
import com.psico.apoia.app.mapper.PsicologoMapper;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.service.IPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PsicologoServiceImpl implements IPsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;


    @Override
    public Psicologo criarPsicologo(Psicologo psicologo) {
        PsicologoEntity psicologoEntity = PsicologoMapper.INSTANCE.psicologToPsicologoEntity(psicologo);
        psicologoRepository.save(psicologoEntity);
        return PsicologoMapper.INSTANCE.psicologoEntityToPsicologo(psicologoEntity);
    }

    @Override
    public List<Psicologo> obterPsicologoPorNome(String nome) {
        List<PsicologoEntity> listaPsicologo = psicologoRepository.findByNomeContainingIgnoreCase(nome);
        return PsicologoMapper.INSTANCE.psicologoEntityToPsicologo(listaPsicologo);
    }



    @Override
    public Psicologo atualizarPsicologo(Psicologo psicologo) {
        return null;
    }

    @Override
    public void deletarPsicologo(Integer idPsicologo) {

    }
}
