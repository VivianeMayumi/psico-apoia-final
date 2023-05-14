package com.psico.apoia.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioLogadoViewController {
    @GetMapping("/carregar-usuario-logado")
    public String carregarUsuarioLogado(Model model) {
        return "usuario_logado";
    }
}
