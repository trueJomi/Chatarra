package com.example.chatarra.Aplication.conveters;

import com.example.chatarra.Aplication.dto.CompradorDto;
import com.example.chatarra.Domain.Entitys.Comprador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CompradorConverter extends AbstractConverter<Comprador, CompradorDto>{

    @Override
    public CompradorDto fromEntity(Comprador entity) {
        if(entity==null) return null;

        return CompradorDto.builder()
                .idShopper(entity.getIdShopper())
                .user(entity.getUser())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .name(entity.getName())
                .area(entity.getArea())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Comprador fromDTO(CompradorDto dto) {
        if(dto==null) return null;
        return Comprador.builder()
                .idShopper(dto.getIdShopper())
                .user(dto.getUser())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .name(dto.getName())
                .area(dto.getArea())
                .status(dto.getStatus())
                .build();
    }
}
