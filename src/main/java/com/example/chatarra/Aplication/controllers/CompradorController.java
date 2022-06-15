package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Domain.Services.CompradorService;
import com.example.chatarra.Domain.Entitys.Comprador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comprador")
public class CompradorController {

    @Autowired
    private CompradorService compradorService;

    @GetMapping("/login/{user}")
    public ResponseEntity<Comprador> login(@PathVariable String user){
        Optional<Comprador> comprador = compradorService.login(user);
        return comprador.map(ResponseEntity::ok).
                orElseGet(()->ResponseEntity.notFound()
                        .build());
    }

}