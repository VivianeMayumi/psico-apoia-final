package com.psico.apoia.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "palestra")
@Getter
@Setter
@NoArgsConstructor
public class PalestraEntity {

    @Id
    @GeneratedValue(generator = "SEQ_PALESTRA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PALESTRA", sequenceName = "SEQ_PALESTRA", allocationSize = 1)
    private Integer id;
    private String titulo;
    private String descricao;
    private String palestrante;
    private LocalDateTime dataHora;
    private String link;
}
