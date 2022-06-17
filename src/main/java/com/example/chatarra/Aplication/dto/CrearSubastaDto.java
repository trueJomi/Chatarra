package com.example.chatarra.Aplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class CrearSubastaDto {
    private Integer idSubasta;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaRecojo;
    private String status;
    private Integer vendedor;
    private CrearChatarraDto chatarra;
}
