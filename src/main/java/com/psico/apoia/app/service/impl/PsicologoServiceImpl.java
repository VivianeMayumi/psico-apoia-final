package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.exception.PsicologoNaoEncontradoException;
import com.psico.apoia.app.mapper.PsicologoMapper;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.service.IPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PsicologoServiceImpl implements IPsicologoService {

    @Autowired
    private PsicologoRepository psicologoRepository;

    @Autowired
    private PsicologoMapper psicologoMapper;


    public Psicologo obterPsicologoPorid(Integer id){
        Optional<PsicologoEntity> optionalPsicologo = psicologoRepository.findById(id);
        return optionalPsicologo.map(psicologo ->{
            return psicologoMapper.psicologoEntityToPsicologo(psicologo);
        }).orElse(null);
    }


    @Override
        public Psicologo criarPsicologo(Psicologo psicologo) {
        PsicologoEntity psicologoEntity = psicologoMapper.psicologoToPsicologoEntity(psicologo);
        psicologoRepository.save(psicologoEntity);
        return psicologoMapper.psicologoEntityToPsicologo(psicologoEntity);
    }


    @Override
    public List<Psicologo> obterPsicologoPorNome(String nome) throws PsicologoNaoEncontradoException {
        List<PsicologoEntity> psicologo = psicologoRepository.findByNomeContainingIgnoreCase(nome);
        for (PsicologoEntity psicologoEntity : psicologo){
            if(psicologoEntity.getNome().equals(nome)){
                return psicologoMapper.psicologoEntityToPsicologo(psicologo);
            }
        }
        throw  new PsicologoNaoEncontradoException("Não foi possível encontrar um psicólogo cadastrado com o nome " + nome +
                ". Por favor, verifique se o nome foi digitado corretamente e tente novamente.");

    }


}
