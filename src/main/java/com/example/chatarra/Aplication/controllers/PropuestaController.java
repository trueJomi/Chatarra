package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Aplication.conveters.PropuestaConverter;
import com.example.chatarra.Aplication.dto.PropuestaDto;
import com.example.chatarra.Aplication.utils.WrapperResponse;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Services.PropuestaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/propuesta")
public class PropuestaController {
    private final PropuestaService propuestaService;
    private final PropuestaConverter propuestaConverter;

    public PropuestaController(PropuestaService propuestaService, PropuestaConverter propuestaConverter){
        this.propuestaService = propuestaService;
        this.propuestaConverter = propuestaConverter;
    }

    @PostMapping("")
    public ResponseEntity<WrapperResponse<PropuestaDto>> crearPropuesta(@RequestBody PropuestaDto propuestaDto){
        Propuesta propuesta = propuestaConverter.fromDTO(propuestaDto);
        Propuesta propuestaNew = propuestaService.crearPropuesta(propuesta);
        PropuestaDto response = propuestaConverter.fromEntity(propuestaNew);
        return new WrapperResponse<PropuestaDto>(true,"success",response).createResponse(HttpStatus.CREATED);
    }
}
