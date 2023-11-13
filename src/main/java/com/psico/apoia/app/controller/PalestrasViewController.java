package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Palestra;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.IPacienteService;
import com.psico.apoia.app.service.IPalestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PalestrasViewController {

    @Autowired
    private IPalestraService palestraService;

    @GetMapping("/carregar-palestras")
    public String carregarPalestras(Model model) {
        model.addAttribute("palestras", palestraService.obterTodasPalestras());
        return "palestras";
    }

    @PostMapping("/carregar-palestra")
    public String carregarPalestras(@ModelAttribute(value="palestra") Palestra palestra, Model model) {
        model.addAttribute("palestra", palestra);
        return "palestra";
    }
}
