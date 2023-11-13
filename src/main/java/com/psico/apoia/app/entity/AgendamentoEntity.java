package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "agendamento",
    indexes = {
        @Index(columnList = "paciente_id"),
    }
)
@Getter
@Setter
@NoArgsConstructor
public class AgendamentoEntity {
    @Id
    @GeneratedValue(generator = "SEQ_AGENDAMENTO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_AGENDAMENTO", sequenceName = "SEQ_AGENDAMENTO", allocationSize = 1)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "agenda_psicologo_id", referencedColumnName = "id")
    private AgendaPsicologoEntity agendaPsicologoEntity;

    private boolean cancelado;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private PacienteEntity paciente;
}
