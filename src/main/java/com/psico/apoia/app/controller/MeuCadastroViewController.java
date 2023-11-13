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
public class MeuCadastroViewController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/carregar-meu-cadastro")
    public String carregarMeuCadastro(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        model.addAttribute("usuarioCadastro", usuario);
        return "meu_cadastro";
    }

    @PostMapping("/atualizar-meu-cadastro")
    public String alterarCadastro(HttpSession session, Model model, Usuario usuario) {
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
        usuario.setId(usuarioLogado.getId());
        usuario.setTipoUsuario(usuarioLogado.getTipoUsuario());
        Usuario usuarioAtualizado = usuarioService.alterarUsuario(usuario);
        session.setAttribute("usuario", usuarioAtualizado);
        model.addAttribute("usuarioCadastro", usuario);
        model.addAttribute("mensagemSucesso", "Cadastro atualizado com sucesso!");
        return "meu_cadastro";
    }
}
