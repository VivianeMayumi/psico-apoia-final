package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.service.IAgendamentoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class SessoesAgendadasViewController {

    @Autowired
    private IAgendamentoService agendamentoService;

    @GetMapping("/carregar-sessoes-agendadas")
    public String carregarSessoesAgendadas(Model model, HttpSession session) {
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        List<Agendamento> agendamentos = agendamentoService.obterAgendamentosPaciente(paciente.getId());
        model.addAttribute("agendamentos", agendamentos);
        return "sessoes_agendadas";
    }

    @GetMapping("/carregar-confirmar-cancelar-sessao")
    public String carregarConfirmarCancelarSessao(Model model, HttpSession session, Agendamento agendamento) {
        model.addAttribute("agendamento", agendamento);
        return "confirmar_cancelar_sessao";
    }

    @PutMapping("/cancelar-sessao-paciente")
    public String cancelarSessao(Model model, HttpSession session, Agendamento agendamento) {
        agendamentoService.cancelarAgendamento(agendamento.getId());
        model.addAttribute("mensagemSucesso", "Sessão cancelada com sucesso!");
        return this.carregarSessoesAgendadas(model, session);
    }
}
