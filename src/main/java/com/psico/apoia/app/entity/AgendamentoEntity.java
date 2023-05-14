package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
@Getter
@Setter
@NoArgsConstructor
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agenda_psicologo_id", referencedColumnName = "id")
    private AgendaPsicologoEntity agendaPsicologoEntity;
    private boolean cancelado;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteEntity paciente;
}
