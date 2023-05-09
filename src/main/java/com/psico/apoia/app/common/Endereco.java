package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    @JsonProperty
    private int cep;
    @JsonProperty
    private String uf;
    @JsonProperty
    private String cidade;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private int numeroResidencia;
    @JsonProperty
    private String complemento;
}
