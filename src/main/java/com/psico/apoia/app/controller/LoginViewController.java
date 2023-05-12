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
public class LoginViewController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/carregar-login")
    public String carregarLogin(Model model, Usuario usuario) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String autenticar(HttpSession session, Model model, Usuario usuario) {
        boolean estaAutenticado = iUsuarioService.validarUsuario(usuario.getUsuario(), usuario.getSenha());
        if (estaAutenticado) {
            Usuario usuarioEncontrado = iUsuarioService.obterUsuario(usuario.getUsuario());
            session.setAttribute("usuario", usuarioEncontrado);
            return "usuario_logado";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }
}
