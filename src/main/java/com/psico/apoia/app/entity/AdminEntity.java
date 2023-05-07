package com.psico.apoia.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_admin")
@Getter
@Setter
@NoArgsConstructor
public class AdminEntity {

    @Id
    private String email;
    private String cpf;
    private String nome;

}
