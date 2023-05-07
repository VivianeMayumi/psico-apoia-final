package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Psicologo {

    @JsonProperty
    private Integer idUsuario;
    @JsonProperty
    private String nome;
    @JsonProperty
    private Date dataNascimento;
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroCrp() {
        return numeroCrp;
    }

    public void setNumeroCrp(String numeroCrp) {
        this.numeroCrp = numeroCrp;
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
