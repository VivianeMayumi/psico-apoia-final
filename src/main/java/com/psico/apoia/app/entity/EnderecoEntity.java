package com.psico.apoia.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
public class EnderecoEntity {

    @Id
    @GeneratedValue(generator = "SEQ_ENDERECO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_ENDERECO", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
    private Integer id;

    private Integer cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private Integer numeroResidencia;
    private String complemento;
}
