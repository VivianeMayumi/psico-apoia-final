package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nome;
    @JsonProperty
    @DateTimeFormat(pattern="yyyy-MM-dd")
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
    private String usuario;
    @JsonProperty
    private String senha;
    @JsonProperty
    private String senhaConfirmacao;
    @JsonProperty
    private Endereco endereco;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
}
