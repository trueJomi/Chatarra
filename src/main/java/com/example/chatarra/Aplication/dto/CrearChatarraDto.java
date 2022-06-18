package com.example.chatarra.Aplication.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter

public class CrearChatarraDto {
    private Integer idChatarra;
    private String titulo;
    private String description;
    private Float precioBase;
    private Integer Vendedor;
}
