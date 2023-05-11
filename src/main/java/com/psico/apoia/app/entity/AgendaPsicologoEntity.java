package com.psico.apoia.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.psico.apoia.app.common.AgendaPsicologo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "agendaPsicologo")
@Getter
@Setter
@NoArgsConstructor


public class AgendaPsicologoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAgendaPsicologo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agenda_psicologo_id")
    private AgendaPsicologo agendaPsicologo;
    private LocalDate data;
    private LocalDateTime horaDoAgendamento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psicologo_id", referencedColumnName = "id")
    private PsicologoEntity psicologo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteEntity paciente;

    private boolean statusDoAgendamento;




}
