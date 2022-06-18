package com.example.chatarra.Aplication.conveters;

import com.example.chatarra.Aplication.dto.PropuestaDto;
import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Entitys.Subasta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PropuestaConverter extends AbstractConverter<Propuesta, PropuestaDto> {

    @Override
    public PropuestaDto fromEntity(Propuesta entity) {

        if(entity==null){
            return null;
        }

        return PropuestaDto.builder()
                .idPropuesta(entity.getIdPropuesta())
                .price(entity.getPrice())
                .time(entity.getTime())
                .comprador(entity.getComprador().getIdShopper())
                .subasta(entity.getSubasta().getIdSubasta())
                .build();
    }

    @Override
    public Propuesta fromDTO(PropuestaDto dto) {

        if(dto ==null) {
            return  null;
        }
        System.out.println(dto);
        Comprador comprador= new Comprador();
        comprador.setIdShopper(dto.getComprador());

        Subasta subasta= new Subasta();
        subasta.setIdSubasta(dto.getSubasta());

        return Propuesta.builder()
                .price(dto.getPrice())
                .comprador(comprador)
                .subasta(subasta)
                .build();
    }
}
