package com.example.chatarra.Aplication.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CompradorDto {
    private Integer idShopper;
    private String user;
    private String password;
    private String phone;
    private String name;
    private String area;
    private String status;
}
