package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.service.IPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PsicologoController {

    @Autowired
    public IPsicologoService psicologoService;

    @PostMapping(value = "/psicologo-cadastrar", produces = "application/json")
    public Psicologo criarPsicologo(@RequestBody final Psicologo psicologo) {
        return psicologoService.criarPsicologo(psicologo);
    }

    @GetMapping(value = "/psicologos-buscar")
    public Iterable<Psicologo> buscarTodosOsPsicologos() {
        return psicologoService.obterTodosPsicologos();
    }

    @GetMapping(value = "/psicologos/{nome}", produces = "application/json")
    public Iterable<Psicologo> obterPorNome(@PathVariable("nome") String nomePsicologo) {
        return psicologoService.obterPsicologoPorNome(nomePsicologo);
    }
}
