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
        autenticacaoService.criarUsuario(usuario.getEmail(), usuario.getSenha(), usuario.getSenhaConfirmacao());
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
