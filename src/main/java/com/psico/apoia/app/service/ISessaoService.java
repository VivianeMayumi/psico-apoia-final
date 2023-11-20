package com.psico.apoia.app.service;

import com.psico.apoia.app.common.AgendaPsicologo;
import com.psico.apoia.app.common.Agendamento;
import com.psico.apoia.app.entity.AgendaPsicologoEntity;
import com.psico.apoia.app.entity.PsicologoEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface ISessaoService {

    public List<AgendaPsicologo> obterSessoesPsicologo(Integer idPsicologo);

    public void confirmarSessao(Integer idAgendaPsicologo, String link);

    public void cancelarSessao(Integer idAgendaPsicologo);

    public void cadastrarNovaSessao(Integer idPsicologo, LocalDateTime dataHora);
}
