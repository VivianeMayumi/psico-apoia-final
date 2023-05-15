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

    @GetMapping("/carregar-excluir-conta")
    public String carregarExcluirConta(HttpSession session, Model model) {
        model.addAttribute("usuario", new Usuario());
        return "excluir_conta_senha";
    }

    @PostMapping("/carregar-confirmar-excluir-conta")
    public String carregarConfirmarrExcluirConta(Usuario usuario, HttpSession session, Model model) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
        if(!iUsuarioService.validarUsuario(usuarioLogado.getUsuario(), usuario.getSenha())) {
            model.addAttribute("mensagemErro", "Senha inválida!");
            return "excluir_conta_senha";
        }
        return "confirmar_excluir_conta";
    }

    @PostMapping("/excluir-conta-senha")
    public String excluirConta(Usuario usuario, HttpSession session, Model model) {
        try {
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
            iUsuarioService.deletarUsuario(usuarioLogado.getUsuario());
        } catch(Exception e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "confirmar_excluir_conta";
        }
        session.removeAttribute("usuario");
        model.addAttribute("mensagemSucesso", "Conta excluída com sucesso!");
        return "login";
    }
}
