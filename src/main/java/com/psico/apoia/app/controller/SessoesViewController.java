package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.service.IAgendamentoService;
import com.psico.apoia.app.service.ISessaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class SessoesViewController {

    @Autowired
    private ISessaoService sessaoService;

    @GetMapping("/carregar-sessoes")
    public String carregarSessoes(Model model, HttpSession session) {
        Psicologo psicologo = (Psicologo) session.getAttribute("psicologo");
        List<AgendaPsicologo> sessoes = sessaoService.obterSessoesPsicologo(psicologo.getId());
        model.addAttribute("sessoes", sessoes);
        return "sessoes";
    }

    @GetMapping("/carregar-confirmar-sessao")
    public String carregarSessoes(Model model, HttpSession session, AgendaPsicologo agendaPsicologo) {
        model.addAttribute("sessao", agendaPsicologo);
        return "confirmar_sessao";
    }

    @PutMapping("/confirmar-sessao")
    public String confirmarSessao(Model model, HttpSession session, AgendaPsicologo agendaPsicologo) {
        sessaoService.confirmarSessao(agendaPsicologo.getId(), agendaPsicologo.getLink());
        model.addAttribute("mensagemSucesso", "Sessão confirmada com sucesso!");
        return this.carregarSessoes(model, session);
    }

    @GetMapping("/carregar-confirmar-cancelar-sessao-psicologo")
    public String carregarConfirmarCancelarSessaoPsicologo(Model model, HttpSession session, AgendaPsicologo agendaPsicologo) {
        model.addAttribute("sessao", agendaPsicologo);
        return "confirmar_cancelar_sessao_psicologo";
    }

    @PutMapping("/cancelar-sessao-psicologo")
    public String cancelarSessao(Model model, HttpSession session, Agendamento agendamento) {
        sessaoService.cancelarSessao(agendamento.getId());
        model.addAttribute("mensagemSucesso", "Sessão cancelada com sucesso!");
        return this.carregarSessoes(model, session);
    }
}
