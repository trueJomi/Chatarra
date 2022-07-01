package com.example.chatarra.Aplication.conveters;

import com.example.chatarra.Aplication.dto.CrearSubastaDto;
import com.example.chatarra.Aplication.dto.PropuestaExtendDto;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Domain.Entitys.Vendedor;
import com.example.chatarra.Domain.Services.PropuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;


@AllArgsConstructor
@Component
public class SubastaConverter extends AbstractConverter<Subasta, CrearSubastaDto> {

    private ChatarraConverter chatarraConverter;
    private PropuestaExtendConverter propuestaExtendConverter;
    private PropuestaConverter propuestaConverter;

    private PropuestaService propuestaService;

    @Override
    public CrearSubastaDto fromEntity(Subasta entity) {

        if (entity == null)
            return null;

        PropuestaExtendDto propuestaExtendDto=null;

        if (entity.getSeleccionado()!=null){
            Propuesta propuesta= propuestaService.BuscarPorId(entity.getSeleccionado());
            propuestaExtendDto=propuestaExtendConverter.fromEntity(propuesta);

        }


        return CrearSubastaDto.builder()
                .idSubasta(entity.getIdSubasta())
                .fecha(entity.getFecha())
                .fechaRecojo(entity.getFechaRecojo())
                .status(entity.getStatus())
                .vendedor(entity.getVendedor().getIdVendedor())
                .seleccionado(propuestaExtendDto)
                .propuestas(propuestaConverter.fromEntity(entity.getPropuestas()))
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
