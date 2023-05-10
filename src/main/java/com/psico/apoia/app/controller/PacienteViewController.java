package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PacienteViewController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/carregar-adicionar-paciente")
    public String showSignUpForm(Model model, Paciente paciente) {
        model.addAttribute("paciente", new Paciente());
        return "adicionar-paciente";
    }

    @GetMapping("/pacientes")
    public String mostrarListaPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.obterTodosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }

    @PostMapping("/adicionar-paciente")
    public String adicionarPaciente(Paciente paciente, Model model) {
        pacienteService.criarPaciente(paciente);
        List<Paciente> pacientes = pacienteService.obterTodosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }

    @PostMapping("/atualizar-paciente/{id}")
    public String atualizarPaciente(@PathVariable("id") Integer idPaciente, Paciente paciente, Model model) {
        paciente.setId(idPaciente);
        pacienteService.atualizarPaciente(paciente);
        List<Paciente> pacientes = pacienteService.obterTodosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }

    @GetMapping("/editar-paciente/{id}")
    public String editarPaciente(@PathVariable("id") Integer idPaciente, Model model) {
        Paciente paciente = pacienteService.obterPacientePorId(idPaciente);
        model.addAttribute("paciente", paciente);
        return "editar-paciente";
    }

    @GetMapping("/deletar-paciente/{id}")
    public String deletarPaciente(@PathVariable("id") Integer idPaciente, Model model) {
        pacienteService.deletarPaciente(idPaciente);
        List<Paciente> pacientes = pacienteService.obterTodosPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }
}
