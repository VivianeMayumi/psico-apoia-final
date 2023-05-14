package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.common.Paciente;
import com.psico.apoia.app.common.Usuario;
import com.psico.apoia.app.service.IAgendamentoService;
import com.psico.apoia.app.service.IPacienteService;
import com.psico.apoia.app.service.IPsicologoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AgendamentoViewController {

    @Autowired
    private IPsicologoService psicologoService;

    @Autowired
    private IPacienteService pacienteService;

    @Autowired
    private IAgendamentoService agendamentoService;

    @GetMapping("/carregar-agendamento")
    public String carregarHome(Model model) {
        model.addAttribute("psicologos", psicologoService.obterTodosPsicologos());
        model.addAttribute("agendamento", new Agendamento());
        return "agendamento";
    }

    @GetMapping(value = "/agendas-disponiveis")
    public @ResponseBody List<AgendaPsicologo> agendasDisponiveis(
            @RequestParam(value = "idPsicologo", required = true) Integer idPsicologo) {
        List<AgendaPsicologo> agendasPsicologo= agendamentoService.buscarAgendaDisponivel(idPsicologo);
        return agendasPsicologo;
    }

    @PostMapping("/agendar")
    public String agendar(HttpSession session, Model model, AgendaPsicologo agenda) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Paciente paciente = pacienteService.obterPacientePorIdUsuario(usuario.getId());
        agendamentoService.agendarSessao(paciente.getId(), agenda.getId());
        return "usuario_logado";
    }
}
