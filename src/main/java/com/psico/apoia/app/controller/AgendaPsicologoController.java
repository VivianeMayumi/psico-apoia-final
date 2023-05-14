package com.psico.apoia.app.controller;

import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;
import com.psico.apoia.app.repository.AgendaPsicologoRepository;
import com.psico.apoia.app.service.IAgendamentoService;
import com.psico.apoia.app.service.IPsicologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgendaPsicologoController {

    @Autowired
    private IAgendamentoService agendaPsicologoService;
    @Autowired
    private IPsicologoService psicologoService;
    @Autowired
    private AgendaPsicologoRepository agendaPsicologoRepository;


    @PostMapping("/criar-agenda")
    public ResponseEntity<AgendaPsicologoEntity> criarAgendaComDiasDoMes(
            @RequestParam int mes,
            @RequestParam int ano,
            @RequestParam PsicologoEntity id) {

        AgendaPsicologoEntity novaAgenda = agendaPsicologoService.criarAgendaComDiasDoMes(mes, ano, id);
        agendaPsicologoRepository.save(novaAgenda);

        return ResponseEntity.ok(novaAgenda);
    }


    @GetMapping("/agenda-disponivel")
    public List<AgendaPsicologoEntity> buscarAgendaDisponivel(
            @RequestParam("mes") int  mes,
            @RequestParam("ano") int ano,
            @RequestParam("psicologoId") PsicologoEntity psicologoId) {

            return null;

    }
}



