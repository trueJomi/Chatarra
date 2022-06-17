package com.example.chatarra.Aplication.conveters;

import com.example.chatarra.Aplication.dto.CrearSubastaDto;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Domain.Entitys.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SubastaConverter extends AbstractConverter<Subasta, CrearSubastaDto> {

    private ChatarraConverter chatarraConverter;

    @Override
    public CrearSubastaDto fromEntity(Subasta entity) {
        if (entity == null)
            return null;
        return CrearSubastaDto.builder()
                .idSubasta(entity.getIdSubasta())
                .fecha(entity.getFecha())
                .fechaRecojo(entity.getFechaRecojo())
                .status(entity.getStatus())
                .vendedor(entity.getVendedor().getIdVendedor())
                .chatarra(chatarraConverter.fromEntity(entity.getChatarra()))
                .build();
    }

    @Override
    public Subasta fromDTO(CrearSubastaDto dto) {
        if (dto == null)
            return null;

        Vendedor newVendedor= new Vendedor();
        newVendedor.setIdVendedor(dto.getVendedor());

        return Subasta.builder()
                .idSubasta(dto.getIdSubasta())
                .chatarra(chatarraConverter.fromDTO(dto.getChatarra()))
                .vendedor(newVendedor)
                .build();
    }
}
