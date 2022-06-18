package com.example.chatarra.Aplication.dto;

import com.example.chatarra.Domain.Entitys.Chatarra;
import com.example.chatarra.Domain.Entitys.Subasta;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class VendedorDto {
    private Integer idVendedor;
    private String user;
    private String password;
    private String phone;
    private String name;
    private String region;
    private String ciudad;
    private String distrito;
    private String direccion;
    private List<CrearChatarraDto> chatarra;
    private List<CrearSubastaDto> subasta;
}
