package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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

    private LocalDate data;
    private LocalDateTime hora;
    private boolean statusDoAgendamento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psicologo_id", referencedColumnName = "id")
    private PsicologoEntity psicologo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteEntity paciente;





}
