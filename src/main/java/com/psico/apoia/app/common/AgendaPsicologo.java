package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class AgendaPsicologo {

    @JsonProperty
    private Integer id;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;
    @JsonProperty
    private Psicologo psicologo;
    @JsonProperty
    private Paciente paciente;
    @JsonProperty
    private boolean disponivel;
    @JsonProperty
    private String status;
    @JsonProperty
    private String link;
}
