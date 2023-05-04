package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String numeroCpf;
    private String numeroRg;
    private String email;
    private String telefone;
}
