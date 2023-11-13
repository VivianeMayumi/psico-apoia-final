package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
public class PacienteEntity {

    @Id
    @GeneratedValue(generator = "SEQ_PACIENTE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PACIENTE", sequenceName = "SEQ_PACIENTE", allocationSize = 1)
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String numeroCpf;
    private String numeroRg;
    private String email;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioEntity usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="paciente")
    private List<AgendamentoEntity> agendamentosPsicologo;
}
