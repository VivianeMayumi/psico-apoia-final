package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.enums.TipoUsuarioEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SelecaoTipoUsuarioPrimeiroAcessoViewController {

    @GetMapping("/carregar-primeiro-acesso-paciente")
    public String carregarPrimeiroAcessoPaciente(Model model) {
        Usuario usuarioPaciente = new Usuario();
        usuarioPaciente.setTipoUsuario(TipoUsuarioEnum.PACIENTE.name());
        model.addAttribute("usuario", usuarioPaciente);
        return "primeiro_acesso";
    }

    @GetMapping("/carregar-primeiro-acesso-psicologo")
    public String carregarPrimeiroAcessoPsicologo(Model model) {
        Usuario usuarioPsicologo = new Usuario();
        usuarioPsicologo.setTipoUsuario(TipoUsuarioEnum.PSICOLOGO.name());
        model.addAttribute("usuario", usuarioPsicologo);
        return "primeiro_acesso";
    }

    @GetMapping("/carregar-selecao-tipo-usuario-primeiro-acesso")
    public String carregarSelecaoTipoUsuarioPrimeiroAcesso(Model model) {
        return "selecao_tipo_usuario_primeiro_acesso";
    }
}
