package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.EnderecoEntity;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.mapper.EnderecoMapper;
import com.psico.apoia.app.mapper.PacienteMapper;
import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Override
    public Paciente obterPacientePorId(Integer id) {
        Optional<PacienteEntity> optionalPaciente = pacienteRepository.findById(id);
        return optionalPaciente.map(paciente -> {
            return pacienteMapper.pacienteEntityToPaciente(paciente);
        }).orElse(null);
    }

    public Paciente criarPaciente(Paciente paciente) {
        PacienteEntity pacienteEntity = pacienteMapper.pacienteToPacienteEntity(paciente);
        pacienteRepository.save(pacienteEntity);
        return pacienteMapper.pacienteEntityToPaciente(pacienteEntity);
    }



    @Override
    public List<Paciente> obterPacientePorNome(String nome) {
        List<PacienteEntity> listaPacientes = pacienteRepository.findByNomeContainingIgnoreCase(nome);
        return pacienteMapper.pacienteEntityToPaciente(listaPacientes);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {

        Optional<PacienteEntity> optionalPacienteEntityBancoDados = pacienteRepository.findById(paciente.getId());
        return optionalPacienteEntityBancoDados.map(pacienteEntityBancoDados -> {
            EnderecoEntity enderecoEntityBanco = pacienteEntityBancoDados.getEndereco();
            EnderecoEntity enderecoEntityAtualizacao = enderecoMapper.enderecoToEnderecoEntity(enderecoEntityBanco, paciente.getEndereco());
            PacienteEntity pacienteEntityAtualizacao = pacienteMapper.pacienteToPacienteEntity(pacienteEntityBancoDados, paciente);
            pacienteEntityAtualizacao.setEndereco(enderecoEntityAtualizacao);
            return pacienteMapper.pacienteEntityToPaciente(pacienteRepository.save(pacienteEntityAtualizacao));
        }).orElse(null);
    }

    @Override
    public void deletarPaciente(Integer idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }

    @Override
    public List<Paciente> obterTodosPacientes() {
        List<Paciente> retorno = new ArrayList<>();
        Optional.of(pacienteRepository.findAll()).ifPresent(listaPacientes -> {
            retorno.addAll(pacienteMapper.pacienteEntityToPaciente((List<PacienteEntity>) pacienteRepository.findAll()));
        });
        return retorno;
    }
}
