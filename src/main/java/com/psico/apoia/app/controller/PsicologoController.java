package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.service.IPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PsicologoController {

    @Autowired
    public IPsicologoService psicologoService;

    @PostMapping(value = "/psicologos", produces = "application/json")
    public Psicologo criarPsicologo(@RequestBody final Psicologo psicologo) {
        return psicologoService.criarPsicologo(psicologo);
    }

    @GetMapping(value = "/psicologos/{nome}", produces = "application/json")
    public List<Psicologo> obterPorNome(@PathVariable("nome") String nomePsicologo) {
        return psicologoService.obterPsicologoPorNome(nomePsicologo);
    }





}
