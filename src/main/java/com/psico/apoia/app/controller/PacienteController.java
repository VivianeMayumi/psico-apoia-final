package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping(value = "/paciente", produces = "application/json")
    public Paciente criarPaciente(@RequestBody final Paciente paciente) {
        return pacienteService.criarPaciente(paciente);
    }

    @GetMapping(value = "/paciente/{nome}", produces = "application/json")
    public List<Paciente> obterPaciente(@PathVariable("nome") String nomePaciente) {
        return pacienteService.obterPacientePorNome(nomePaciente);
    }

    @PutMapping(value = "/paciente", produces = "application/json")
    public Paciente atualizarPaciente(@RequestBody final Paciente paciente) {
        return pacienteService.atualizarPaciente(paciente);
    }

    @DeleteMapping(value = "/paciente/{id}", produces = "application/json")
    public void deletarPaciente(@PathVariable("id") Integer idPaciente) {
        pacienteService.deletarPaciente(idPaciente);
    }
}
