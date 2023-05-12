package com.psico.apoia.app.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    @GetMapping("/carregar-home")
    public String carregarHome(Model model) {
        return "home";
    }

    @GetMapping("/logout")
    public String carregarHome(HttpSession session) {
        session.removeAttribute("usuario");
        return "home";
    }
}
