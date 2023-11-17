package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrimeiroAcessoViewController {

    @GetMapping("/carregar-primeiro-acesso")
    public String carregarPrimeiroAcesso(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "primeiro_acesso";
    }

    @GetMapping("/primeiro-acesso-paciente")
    public String carregarPaginaPaciente(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "primeiro_acesso_paciente";
    }
    @GetMapping("/primeiro-acesso-psicologo")
    public String carregarPaginaPsicologo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "primeiro_acesso_psicologo";
    }
}
