package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.ICadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PrimeiroAcessoViewController {

    @Autowired
    private ICadastroService cadastroService;

    @GetMapping("/carregar-primeiro-acesso")
    public String carregarPrimeiroAcesso(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "primeiro_acesso";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Model model, Usuario usuario) {
        cadastroService.cadastrar(usuario);
        return "login";
    }
}
