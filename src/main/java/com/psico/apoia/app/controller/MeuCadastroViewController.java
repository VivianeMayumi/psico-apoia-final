package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeuCadastroViewController {

    @GetMapping("/carregar-meu-cadastro")
    public String carregarHome(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuario", usuario);
        return "meu_cadastro";
    }
}
