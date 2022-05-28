package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Domain.Services.VendedoresService;
import com.example.chatarra.Domain.entitys.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorControllers {

    private final VendedoresService vendedoresService;

    public VendedorControllers(VendedoresService vendedoresService) {
        this.vendedoresService = vendedoresService;
    }

    @PostMapping
    public ResponseEntity<Vendedor> CrearVendedor(@Valid @RequestBody Vendedor vendedor) {
        Vendedor vendedorNew = vendedoresService.crearVendedor(vendedor);
        return  new ResponseEntity<Vendedor>(vendedorNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> ListarVendedores() {
        List<Vendedor> vendedores = vendedoresService.ObtenerVendedores();
        return  new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.CREATED);
    }

}
