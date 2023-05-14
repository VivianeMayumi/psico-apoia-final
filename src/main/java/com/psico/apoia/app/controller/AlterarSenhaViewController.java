package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.AlteracaoSenha;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlterarSenhaViewController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/carregar-alterar-senha")
    public String carregarAlterarSenha(HttpSession session, Model model, Usuario usuario) {
        model.addAttribute("alteracaoSenha", new AlteracaoSenha());
        return "alterar_senha";
    }

    @PostMapping("/alterar-senha")
    public String alterarSenha(HttpSession session, Model model, AlteracaoSenha alteracaoSenha) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        try {
            iUsuarioService.alterarSenha(usuario.getId(), alteracaoSenha.getSenhaAtual(), alteracaoSenha.getSenha(), alteracaoSenha.getSenhaConfirmacao());
        } catch(Exception e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "alterar_senha";
        }
        return "usuario_logado";
    }
}
