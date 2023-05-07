package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin {

    @JsonProperty
    private String cpf;

    @JsonProperty
    private String nome;

    public Admin() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
