package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.exception.SenhaInvalidaException;
import com.psico.apoia.app.service.IAutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutenticacaoController {

    @Autowired
    private IAutenticacaoService autenticacaoService;

    @PostMapping(value = "/login")
    public ResponseEntity<Object> autenticar(@RequestBody Usuario usuario) {
        boolean estaAutenticado = autenticacaoService.autenticar(usuario.getEmail(), usuario.getSenha());
        if (estaAutenticado) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping(value = "/cadastrar-login")
    public ResponseEntity<Object> cadastrar(@RequestBody Usuario usuario) {
        autenticacaoService.cadastrarLogin(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<?> alterarSenha(@RequestParam String email, @RequestParam String senhaAntiga,
                                          @RequestParam String senhaNova) {
        try {
            autenticacaoService.alterarSenha(email, senhaAntiga, senhaNova);
            return ResponseEntity.ok().build();
        } catch (SenhaInvalidaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
