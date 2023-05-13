package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeuCadastroViewController {

    @GetMapping("/carregar-meu-cadastro")
    public String carregarHome(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "meu_cadastro";
    }
}
