package com.psico.apoia.app.service.impl;

import com.psico.apoia.app.repository.PacienteRepository;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.entity.PacienteEntity;
import com.psico.apoia.app.mapper.PacienteMapper;
import com.psico.apoia.app.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPaciente(Paciente paciente) {
        PacienteEntity pacienteEntity = PacienteMapper.INSTANCE.pacienteToPacienteEntity(paciente);
        pacienteRepository.save(pacienteEntity);
        return PacienteMapper.INSTANCE.pacienteEntityToPaciente(pacienteEntity);
    }

    @Override
    public List<Paciente> obterPacientePorNome(String nome) {
        List<PacienteEntity> listaPacientes = pacienteRepository.findByNomeContainingIgnoreCase(nome);
        return PacienteMapper.INSTANCE.pacienteEntityToPaciente(listaPacientes);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {

        Optional<PacienteEntity> optionalPacienteEntityBancoDados = pacienteRepository.findById(paciente.getId());
        return optionalPacienteEntityBancoDados.map(pacienteEntityBancoDados -> {
            pacienteEntityBancoDados.setDataNascimento(paciente.getDataNascimento());
            pacienteEntityBancoDados.setNome(paciente.getNome());
            pacienteEntityBancoDados.setTelefone(paciente.getTelefone());
            pacienteEntityBancoDados.setEmail(paciente.getEmail());
            pacienteEntityBancoDados.setNumeroCpf(paciente.getNumeroCpf());
            pacienteEntityBancoDados.setNumeroRg(paciente.getNumeroRg());
            return PacienteMapper.INSTANCE.pacienteEntityToPaciente(pacienteRepository.save(pacienteEntityBancoDados));
        }).orElse(null);
    }

    @Override
    public void deletarPaciente(Integer idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }
}
