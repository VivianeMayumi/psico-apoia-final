package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "psicologo")
@Getter
@Setter
@NoArgsConstructor
public class PsicologoEntity {

    @Id
    @GeneratedValue(generator = "SEQ_PSICOLOGO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PSICOLOGO", sequenceName = "SEQ_PSICOLOGO", allocationSize = 1)
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private String numeroCrp;
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
}
