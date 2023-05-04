package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Paciente;

import java.util.List;

public interface IPacienteService {

    public Paciente criarPaciente(Paciente paciente);

    public List<Paciente> obterPacientePorNome(String nome);

    public Paciente atualizarPaciente(Paciente paciente);

    public void deletarPaciente(Integer idPaciente);
}
