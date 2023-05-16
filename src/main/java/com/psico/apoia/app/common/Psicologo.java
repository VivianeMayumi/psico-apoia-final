package com.psico.apoia.app.common;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Psicologo{

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private LocalDate dataNascimento;
    @JsonProperty
    private String numeroCrp;
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


}
