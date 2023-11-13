package com.psico.apoia.app.entity;

import com.psico.apoia.app.enums.TipoUsuarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(generator = "SEQ_USUARIO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    private Integer id;

    @Column(unique=true)
    private String usuario;

    private String senha;

    private String tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="usuario")
    private PacienteEntity paciente;

    @OneToOne(cascade = CascadeType.ALL, mappedBy="usuario")
    private PsicologoEntity psicologo;
}
