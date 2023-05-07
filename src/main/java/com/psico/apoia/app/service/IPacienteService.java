package com.psico.apoia.app.service;

import com.psico.apoia.app.common.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente obterPacientePorId(Integer id);

    Paciente criarPaciente(Paciente paciente);

    List<Paciente> obterPacientePorNome(String nome);

    Paciente atualizarPaciente(Paciente paciente);

    void deletarPaciente(Integer idPaciente);

    public List<Paciente> obterTodosPacientes();
}
