package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Domain.Services.VendedorService;
import com.example.chatarra.Domain.Entitys.Vendedor;
import com.example.chatarra.Aplication.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorControllers {

    private final VendedorService vendedorService;

    public VendedorControllers(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }


    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public Vendedor login(@Valid @RequestBody Vendedor vendedor) throws Exception {
        String user = vendedor.getUser();
        String password = vendedor.getPassword();
        Vendedor vendedorNew = null;
        if (user != null && password != null) {
            vendedorNew = vendedorService.login(user, password);
        }
        if (vendedorNew == null) {
            throw new Exception("Malas Credenciales");
        }
        return vendedorNew;
    }
    @GetMapping("/{idVendedor}")
    public ResponseEntity<WrapperResponse<Vendedor>> buscarPorId(@PathVariable("idVendedor") Integer idVendedor ) {
        Vendedor vendedor = vendedorService.buscarPorId(idVendedor);
        return new WrapperResponse<>(true, "success", vendedor).createResponse();

    }
    @PostMapping
    public ResponseEntity<Vendedor> CrearVendedor(@Valid @RequestBody Vendedor vendedor) {
        Vendedor vendedorNew = vendedorService.crearVendedor(vendedor);
        return  new ResponseEntity<Vendedor>(vendedorNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> ListarVendedores() {
        List<Vendedor> vendedores = vendedorService.ObtenerVendedores();
        return  new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.CREATED);
    }
}









