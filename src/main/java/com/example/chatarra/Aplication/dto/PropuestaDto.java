package com.example.chatarra.Aplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class PropuestaDto {
    private Integer idPropuesta;
    private String price;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate time;
    private Integer subasta;
    private Integer comprador;

}
