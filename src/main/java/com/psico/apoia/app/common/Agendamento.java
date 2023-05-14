package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
public class Agendamento {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private Integer idPsicologo;
}
