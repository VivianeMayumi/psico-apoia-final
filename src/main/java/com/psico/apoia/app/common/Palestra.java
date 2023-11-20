package com.psico.apoia.app.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Palestra {

    @JsonProperty
    private Integer id;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;
    @JsonProperty
    private String titulo;
    @JsonProperty
    private String descricao;
    @JsonProperty
    private String palestrante;
    @JsonProperty
    private String link;
}
