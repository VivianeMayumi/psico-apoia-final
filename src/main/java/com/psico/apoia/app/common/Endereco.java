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
    private Integer cep;
    @JsonProperty
    private String uf;
    @JsonProperty
    private String cidade;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String logradouro;
    @JsonProperty
    private Integer numeroResidencia;
    @JsonProperty
    private String complemento;
}
