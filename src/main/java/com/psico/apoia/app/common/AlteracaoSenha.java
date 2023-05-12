package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AlteracaoSenha {

    @JsonProperty
    private String senhaAtual;
    @JsonProperty
    private String senha;
    @JsonProperty
    private String senhaConfirmacao;
}
