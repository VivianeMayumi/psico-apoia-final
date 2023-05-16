package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Paciente {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private LocalDate dataNascimento;
    @JsonProperty
    private String numeroCpf;
    @JsonProperty
    private String numeroRg;
    @JsonProperty
    private String email;
    @JsonProperty
    private String telefone;
    @JsonProperty
    private Endereco endereco;
    @JsonProperty
    private Integer idUsuario;
}
