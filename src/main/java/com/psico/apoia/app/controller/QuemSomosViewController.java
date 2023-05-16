package com.psico.apoia.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuemSomosViewController {

    @GetMapping("/carregar-quem-somos")
    public String carregarQuemSomos(Model model) {
        return "quem_somos";
    }
}
