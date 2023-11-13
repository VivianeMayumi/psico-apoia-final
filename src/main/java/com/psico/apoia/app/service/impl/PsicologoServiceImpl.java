package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.entity.EnderecoEntity;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.entity.UsuarioEntity;
import com.psico.apoia.app.exception.PsicologoNaoEncontradoException;
import com.psico.apoia.app.mapper.EnderecoMapper;
import com.psico.apoia.app.mapper.PsicologoMapper;
import com.psico.apoia.app.repository.PsicologoRepository;
import com.psico.apoia.app.repository.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PsicologoMapper psicologoMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public Psicologo obterPsicologoPorId(Integer id){
        Optional<PsicologoEntity> optionalPsicologo = psicologoRepository.findById(id);
        return optionalPsicologo.map(psicologo ->{
            return psicologoMapper.psicologoEntityToPsicologo(psicologo);
        }).orElse(null);
    }

    @Override
        public Psicologo criarPsicologo(Psicologo psicologo) {
        PsicologoEntity psicologoEntity = psicologoMapper.psicologoToPsicologoEntity(psicologo);
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(psicologo.getIdUsuario());
        optionalUsuarioEntity.ifPresent(psicologoEntity::setUsuario);
        PsicologoEntity psicologoCriado = psicologoRepository.save(psicologoEntity);
        return psicologoMapper.psicologoEntityToPsicologo(psicologoCriado);
    }

    @Override
    public Iterable<Psicologo> obterPsicologoPorNome(String nome) throws PsicologoNaoEncontradoException {
        List<PsicologoEntity> psicologo = psicologoRepository.findByNomeContainingIgnoreCase(nome);
        for (PsicologoEntity psicologoEntity : psicologo){
            if(psicologoEntity.getNome().equals(nome)){
                return psicologoMapper.psicologoEntityToPsicologo(psicologo);
            }
        }
        throw  new PsicologoNaoEncontradoException("Não foi possível encontrar um psicólogo cadastrado com o nome " + nome +
                ". Por favor, verifique se o nome foi digitado corretamente e tente novamente.");

    }

    @Override
    public Iterable<Psicologo> obterTodosPsicologos() {
        return psicologoMapper.psicologoEntityToPsicologo(psicologoRepository.findAll());
    }

    @Override
    public Psicologo obterPsicologoPorIdUsuario(Integer idUsuario) {
        return psicologoMapper.psicologoEntityToPsicologo(psicologoRepository.findByUsuarioId(idUsuario));
    }

    @Override
    public Psicologo atualizarPsicologo(Psicologo psicologo) {

        Optional<PsicologoEntity> optionalPsicologoEntityBancoDados = psicologoRepository.findById(psicologo.getId());
        return optionalPsicologoEntityBancoDados.map(psicologoEntityBancoDados -> {
            EnderecoEntity enderecoEntityBanco = psicologoEntityBancoDados.getEndereco();
            EnderecoEntity enderecoEntityAtualizacao = enderecoMapper.enderecoToEnderecoEntity(enderecoEntityBanco, psicologo.getEndereco());
            PsicologoEntity psicologoEntityAtualizacao = psicologoMapper.psicologoToPsicologoEntity(psicologoEntityBancoDados, psicologo);
            psicologoEntityAtualizacao.setEndereco(enderecoEntityAtualizacao);
            return psicologoMapper.psicologoEntityToPsicologo(psicologoRepository.save(psicologoEntityAtualizacao));
        }).orElse(null);
    }
}
