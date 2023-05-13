package com.psico.apoia.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoacaoViewController {

    @GetMapping("/carregar-doacao")
    public String carregarHome(Model model) {
        return "doacao";
    }
}
