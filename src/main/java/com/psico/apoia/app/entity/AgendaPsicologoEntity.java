package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    @ElementCollection
    private List<LocalDate> dataDisponivel;
    private int mes;
    private int ano;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psicologo_id", referencedColumnName = "id")
    private PsicologoEntity psicologo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteEntity paciente;

}
