package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Psicologo;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.service.IAgendaPsicologoService;
import com.psico.apoia.app.service.IPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AgendaPsicologoController {

    @Autowired
    private IAgendaPsicologoService agendaPsicologoService;
    @Autowired
    private IPsicologoService psicologoService;

    @PostMapping("/criar-agenda")
    public AgendaPsicologoEntity criarAgendaComDiasDoMes(
            @RequestParam("mes") int mes,
            @RequestParam("ano") int ano,
            @RequestParam("id-psicologo") int idPsicologo){
        PsicologoEntity psicologo = new PsicologoEntity();
        psicologo.setId(idPsicologo);

        return agendaPsicologoService.criarAgendaComDiasDoMes(mes, ano, psicologo);
    }
    @GetMapping("/agenda-disponivel")
    public List<AgendaPsicologoEntity> buscarAgendaDisponivel(
            @RequestParam("mes") int  mes,
            @RequestParam("ano") int ano,
            @RequestParam("psicologoId") PsicologoEntity psicologoId) {

            return null;

    }
}



