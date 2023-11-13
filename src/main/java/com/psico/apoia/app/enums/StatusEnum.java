package com.psico.apoia.app.enums;

public enum StatusEnum {

    CONFIRMADA("Confirmada"),
    A_CONFIRMAR("A Confirmar"),
    DISPONIVEL("Disponivel"),
    CANCELADA("Cancelada");

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
