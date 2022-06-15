package com.example.chatarra.Aplication.conveters;

import com.example.chatarra.Aplication.dto.CrearChatarraDto;
import com.example.chatarra.Domain.Entitys.Chatarra;
import com.example.chatarra.Domain.Entitys.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ChatarraConverter extends  AbstractConverter<Chatarra, CrearChatarraDto>{

    @Override
    public CrearChatarraDto fromEntity(Chatarra entity) {

        if(entity==null) return  null;

        return CrearChatarraDto.builder()
                .idChatarra(entity.getIdChatarra())
                .titulo(entity.getTitulo())
                .description(entity.getDescription())
                .precioBase(entity.getPrecioBase())
                .Vendedor(entity.getVendedor().getIdVendedor())
                .build();
    }

    @Override
    public Chatarra fromDTO(CrearChatarraDto dto) {

        if(dto==null) return  null;
        Vendedor newVendedor= new Vendedor();
        newVendedor.setIdVendedor(dto.getVendedor());
        return Chatarra.builder()
                .idChatarra(dto.getIdChatarra())
                .titulo(dto.getTitulo())
                .description(dto.getDescription())
                .precioBase(dto.getPrecioBase())
                .vendedor(newVendedor)
                .build();
    }
}
