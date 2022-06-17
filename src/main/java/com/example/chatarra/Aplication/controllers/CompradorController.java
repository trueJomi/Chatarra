package com.example.chatarra.Aplication.controllers;

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

    public CompradorController(CompradorService compradorService){
        this.compradorService=compradorService;
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public Comprador login(@Valid @RequestBody Comprador comprador) throws Exception{
        String user = comprador.getUser();
        String password = comprador.getPassword();
        Comprador compradorNew=null;
        if(user!=null && password!=null){
            compradorNew=compradorService.login(user,password);
        }
        if(compradorNew==null){
            throw new Exception("Malas Credenciales");
        }
        return compradorNew;
    }
    @GetMapping("/{idShopper}")
    public ResponseEntity<WrapperResponse<Comprador>> buscarPorId(@PathVariable("idShopper") Integer idShopper ){
        Comprador comprador = compradorService.buscarPorId(idShopper);
        return new WrapperResponse<>(true,"success",comprador).createResponse();
    }
}