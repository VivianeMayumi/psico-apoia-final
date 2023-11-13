package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.exception.SenhaInvalidaException;
import com.psico.apoia.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacaoController {

    @Autowired
    private IUsuarioService autenticacaoService;

    @PostMapping(value = "/cadastrar-login")
    public ResponseEntity<Object> cadastrar(@RequestBody Usuario usuario) {
        autenticacaoService.criarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

}
