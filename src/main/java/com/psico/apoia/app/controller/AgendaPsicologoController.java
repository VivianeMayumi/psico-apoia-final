package com.psico.apoia.app.controller;

import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.service.IAgendaPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AgendaPsicologoController {

    @Autowired
    private IAgendaPsicologoService agendaPsicologoService;

    @GetMapping("/agenda-disponivel")
    public List<AgendaPsicologoEntity> buscarAgendaDisponivel(
            @RequestParam("dataInicio") LocalDate dataInicio,
            @RequestParam("dataFim") LocalDate dataFim) {

        List<AgendaPsicologoEntity> agendasDisponiveis =
                agendaPsicologoService.buscarAgendaDisponível(dataInicio, dataFim);

        return agendasDisponiveis;
    }
}



