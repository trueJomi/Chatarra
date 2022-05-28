package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Domain.Services.CrearSubastaService;
import com.example.chatarra.Domain.entitys.Subasta;
import com.example.chatarra.utils.WrapperResponse;
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
    public ResponseEntity<WrapperResponse<Subasta>> CrearSubasta(@Valid @RequestBody Subasta subasta) {
        Subasta SubastaNew = crearSubastaService.crearSubasta(subasta);
        return  new WrapperResponse<Subasta>(true,"success",SubastaNew).createResponse( HttpStatus.CREATED);
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<WrapperResponse<Subasta>> Eliminar(@PathVariable("id") Integer id) {
        Subasta SubastaDeleted = crearSubastaService.eliminarSubasta(id);
        return  new WrapperResponse<Subasta>(true,"success",SubastaDeleted).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{ids}")
    public ResponseEntity<WrapperResponse<List<Subasta>>> Listar(@PathVariable("ids") Integer id){
        List<Subasta> subastasList= crearSubastaService.misSubastas(id);
        return  new WrapperResponse<List<Subasta>>(true,"success",subastasList).createResponse(HttpStatus.OK);
    }

    @GetMapping("estados/{ides}/{estado}")
    public ResponseEntity<WrapperResponse<List<Subasta>>> Listar(@PathVariable("ides") Integer id, @PathVariable("estado") String estado){
        List<Subasta> subastasList= crearSubastaService.SubsatasEstados(id,estado);
        return  new WrapperResponse<List<Subasta>>(true,"success",subastasList).createResponse(HttpStatus.OK);
    }

}
