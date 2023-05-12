package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class AgendaPsicologo {


    @JsonProperty
    private Integer idAgendaPsicologo;
    @JsonProperty
    private LocalDate data;
    @JsonProperty
    private LocalDateTime hora;
    @JsonProperty
    private Psicologo psicologo;
    @JsonProperty
    private Paciente paciente;
    @JsonProperty
    private boolean statusDoAgendamento; //vai estar agendado true ou false; pensando na possibilidade de utilizar um enum!



}
