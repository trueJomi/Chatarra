package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Domain.Services.CrearSubastaService;
import com.example.chatarra.Domain.entitys.Subasta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/crearSubasta")
public class CrearSubastaController {

    private final CrearSubastaService crearSubastaService;

    public CrearSubastaController(CrearSubastaService crearSubastaService) {
        this.crearSubastaService = crearSubastaService;
    }

    @PostMapping
    public ResponseEntity<Subasta> CrearSubasta(@Valid @RequestBody Subasta subasta) {
        Subasta SubastaNew = crearSubastaService.crearSubasta(subasta);
        return  new ResponseEntity<Subasta>(SubastaNew, HttpStatus.CREATED);
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<Subasta> Elimianar(@PathVariable Integer id) {
        Subasta SubastaDeleted = crearSubastaService.eliminarSubasta(id);
        return  new ResponseEntity<>(SubastaDeleted, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Subasta>> Listar(@PathVariable Integer id){
        List<Subasta> subastasList= crearSubastaService.misSubastas(id);
        return  new ResponseEntity<List<Subasta>>(subastasList, HttpStatus.OK);
    }


}
