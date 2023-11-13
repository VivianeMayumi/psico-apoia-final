package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.ISessaoService;
import com.psico.apoia.app.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NovaSessaoViewController {

    @Autowired
    private ISessaoService sessaoService;

    @GetMapping("/carregar-cadastrar-nova-sessao")
    public String carregarCadastrarNovaSessao(Model model, HttpSession session) {
        Psicologo psicologo = (Psicologo) session.getAttribute("psicologo");
        model.addAttribute("psicologo", psicologo);
        return "cadastrar_nova_sessao";
    }

    @PostMapping("/carregar-confirmar-cadastrar-nova-sessao")
    public String carregarCadastrarNovaSessao(Model model, HttpSession session, AgendaPsicologo sessao) {
        model.addAttribute("sessao", sessao);
        return "confirmar_cadastrar_nova_sessao";
    }

    @PostMapping("/cadastrar-nova-sessao")
    public String agendar(HttpSession session, Model model, AgendaPsicologo agenda) {
        try {
            Psicologo psicologo = (Psicologo) session.getAttribute("psicologo");
            sessaoService.cadastrarNovaSessao(psicologo.getId(), agenda.getDataHora());
        } catch(Exception e) {
            model.addAttribute("mensagemErro", "Erro ao cadasrar a nova sessão!");
        }
        model.addAttribute("mensagemSucesso", "Cadastro realizado com sucesso!");
        return "usuario_logado";
    }
}
