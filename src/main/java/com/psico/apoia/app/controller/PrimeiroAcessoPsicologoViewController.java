package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.ICadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PrimeiroAcessoPsicologoViewController {

    @Autowired
    private ICadastroService cadastroService;

    @GetMapping("/carregar-primeiro-acesso-psicologo")
    public String carregarPrimeiroAcesso(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "primeiro_acesso_psicologo";
    }

    @PostMapping("/cadastrar-psicologo")
    public String cadastrar(Model model, Usuario usuario) {
        try {
            cadastroService.cadastrar(usuario);
        } catch(Exception e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "primeiro_acesso_psicologo";
        }
        model.addAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
        return "login";
    }
}
