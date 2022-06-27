package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Aplication.conveters.PropuestaConverter;
import com.example.chatarra.Aplication.conveters.PropuestaExtendConverter;
import com.example.chatarra.Aplication.dto.PropuestaDto;
import com.example.chatarra.Aplication.dto.PropuestaExtendDto;
import com.example.chatarra.Aplication.utils.WrapperResponse;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Services.PropuestaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propuesta")
public class PropuestaController {

    private final PropuestaService propuestaService;
    private final PropuestaConverter propuestaConverter;

    private final PropuestaExtendConverter propuestaExtendConverter;

    public PropuestaController(PropuestaService propuestaService, PropuestaConverter propuestaConverter, PropuestaExtendConverter propuestaExtendConverter) {
        this.propuestaService = propuestaService;
        this.propuestaConverter = propuestaConverter;
        this.propuestaExtendConverter = propuestaExtendConverter;
    }

    @PostMapping("")
    public ResponseEntity<WrapperResponse<PropuestaDto>> CrearPropuesta(@RequestBody PropuestaDto propuesta) {
        Propuesta lapropuesta = propuestaConverter.fromDTO(propuesta);
        Propuesta propuestacreada = propuestaService.crearPropuesta(lapropuesta);
        PropuestaDto response = propuestaConverter.fromEntity(propuestacreada);
        return new WrapperResponse<PropuestaDto>(true,"success",response)
                .createResponse( HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<PropuestaDto>> ObtenerPorId(@PathVariable("id") Integer id){
        Propuesta propuesta = propuestaService.BuscarPorId(id);
        PropuestaDto response= propuestaConverter.fromEntity(propuesta);
        return new WrapperResponse<PropuestaDto>(true,"success",response)
                .createResponse( HttpStatus.OK);
    }

    @GetMapping("comprador/{id}")
    public ResponseEntity<WrapperResponse<List<PropuestaDto>>> ObtenerPorUser(@PathVariable("id") Integer id){
        List<Propuesta> propuesta = propuestaService.propuestaPorUser(id);
        List<PropuestaDto> response= propuestaConverter.fromEntity(propuesta);
        return new WrapperResponse<List<PropuestaDto>>(true,"success",response)
                .createResponse( HttpStatus.OK);
    }

    @GetMapping("subasta/{id}")
    public ResponseEntity<WrapperResponse<List<PropuestaDto>>> ObtenerPorSubasta(@PathVariable("id") Integer id){
        List<Propuesta> propuestas = propuestaService.propuestaPorSubasta(id);
        List<PropuestaDto> response= propuestaConverter.fromEntity(propuestas);
        return new WrapperResponse<List<PropuestaDto>>(true,"success",response)
                .createResponse( HttpStatus.OK);
    }

    @GetMapping("mayor/{id}")
    public  ResponseEntity<WrapperResponse<PropuestaExtendDto>> ObtenerMayor(@PathVariable("id") Integer id){
        Propuesta propuesta= propuestaService.PropuestaMayor(id);
        PropuestaExtendDto result= propuestaExtendConverter.fromEntity(propuesta);
        return new WrapperResponse<PropuestaExtendDto>(true,"success",result)
                .createResponse( HttpStatus.OK);
    }

}
