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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime dataHora;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "psicologo_id", referencedColumnName = "id")
    private PsicologoEntity psicologo;
    private boolean disponivel;
}
