package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Aplication.conveters.CompradorConverter;
import com.example.chatarra.Aplication.dto.CompradorDto;
import com.example.chatarra.Aplication.utils.WrapperResponse;
import com.example.chatarra.Domain.Services.CompradorService;
import com.example.chatarra.Domain.Entitys.Comprador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comprador")
public class CompradorController {

    private final CompradorService compradorService;
    private final CompradorConverter compradorConverter;

    public CompradorController(CompradorService compradorService, CompradorConverter compradorConverter){
        this.compradorService=compradorService;
        this.compradorConverter=compradorConverter;
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public CompradorDto login(@RequestBody CompradorDto compradorDto) throws Exception{
        Comprador comprador=compradorConverter.fromDTO(compradorDto);
        String user = comprador.getUser();
        String password = comprador.getPassword();
        Comprador compradorNew=null;

        if(user!=null && password!=null){
            compradorNew=compradorService.login(user,password);
        }
        if(compradorNew==null){
            throw new Exception("Malas Credenciales");
        }
        CompradorDto response = compradorConverter.fromEntity(compradorNew);
        return response;
    }
    @GetMapping("/{idShopper}")
    public ResponseEntity<WrapperResponse<CompradorDto>> buscarPorId(@PathVariable("idShopper") Integer idShopper ){
        Comprador comprador = compradorService.buscarPorId(idShopper);
        CompradorDto compradorDto = compradorConverter.fromEntity(comprador);
        return new WrapperResponse<>(true,"success",compradorDto).createResponse();
    }
}