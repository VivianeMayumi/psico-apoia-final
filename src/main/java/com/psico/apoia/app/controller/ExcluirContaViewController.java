package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExcluirContaViewController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/confirmar_excluir_conta")
    public String confirmarExcluirConta(HttpSession session, Model model) {
        return "excluir_conta_senha";
    }

    @PostMapping("/excluir_conta_senha")
    public String excluirConta(Usuario usuario, HttpSession session, Model model) {
        try {
            iUsuarioService.deletarUsuario(usuario.getId(), usuario.getSenhaConfirmacao());
        } catch(Exception e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "excluir_conta_senha";
        }
        return "carregar-home";

    }

}
