package com.example.chatarra.Aplication.dto;

import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Builder
@Getter

public class PropuestaDto {
    private Integer idPropuesta;
    private Float price;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime time;
    private Integer subasta;
    private Integer comprador;
}
