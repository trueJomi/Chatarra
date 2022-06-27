package com.example.chatarra.Aplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class PropuestaExtendDto {
    private Integer idPropuesta;
    private Float price;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime time;
    private Integer subasta;
    private CompradorDto comprador;
}
