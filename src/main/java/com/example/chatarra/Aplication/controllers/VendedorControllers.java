package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Aplication.conveters.VendedorConverter;
import com.example.chatarra.Aplication.dto.VendedorDto;
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
    private final VendedorConverter vendedorConverter;

    public VendedorControllers(VendedorService vendedorService, VendedorConverter vendedorConverter) {
        this.vendedorService = vendedorService;
        this.vendedorConverter = vendedorConverter;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<WrapperResponse<VendedorDto>> login(@RequestBody Vendedor vendedor) throws Exception {
        String user = vendedor.getUser();
        String password = vendedor.getPassword();
        Vendedor vendedorNew = null;
        if (user != null && password != null) {
            vendedorNew = vendedorService.login(user, password);
        }
        if (vendedorNew == null) {
            throw new Exception("Malas Credenciales");
        }
        VendedorDto response= vendedorConverter.fromEntity(vendedorNew);
        return new WrapperResponse<VendedorDto>(true,"success",response)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping("/{idVendedor}")
    public ResponseEntity<WrapperResponse<VendedorDto>> buscarPorId(@PathVariable("idVendedor") Integer idVendedor ) {
        Vendedor vendedor = vendedorService.buscarPorId(idVendedor);
        VendedorDto vendedorDto= vendedorConverter.fromEntity(vendedor);
        return new WrapperResponse<VendedorDto>(true, "success", vendedorDto)
                .createResponse(HttpStatus.OK);

    }
}









