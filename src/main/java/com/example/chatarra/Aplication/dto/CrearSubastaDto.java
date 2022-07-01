package com.example.chatarra.Aplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Builder
@Setter
@Getter

public class CrearSubastaDto {
    private Integer idSubasta;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fecha;
    private PropuestaExtendDto seleccionado;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaRecojo;
    private List<PropuestaDto> propuestas;
    private String status;
    private Integer vendedor;
    private CrearChatarraDto chatarra;
}
