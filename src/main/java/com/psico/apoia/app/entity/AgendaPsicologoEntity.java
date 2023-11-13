package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda_psicologo")
@Getter
@Setter
@NoArgsConstructor
public class AgendaPsicologoEntity {

    @Id
    @GeneratedValue(generator = "SEQ_AGENDA_PSICOLOGO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_AGENDA_PSICOLOGO", sequenceName = "SEQ_AGENDA_PSICOLOGO", allocationSize = 1)
    private Integer id;
    private LocalDateTime dataHora;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "psicologo_id", referencedColumnName = "id")
    private PsicologoEntity psicologo;

    @OneToOne(mappedBy = "agendaPsicologoEntity", cascade = CascadeType.ALL)
    private AgendamentoEntity agendamento;

    private String status;

    private String link;

    private boolean disponivel;
}
