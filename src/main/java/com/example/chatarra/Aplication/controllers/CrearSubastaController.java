package com.example.chatarra.Aplication.controllers;

import com.example.chatarra.Aplication.conveters.SubastaConverter;
import com.example.chatarra.Aplication.dto.CrearSubastaDto;
import com.example.chatarra.Domain.Services.CrearSubastaService;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Aplication.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/crearSubasta")
public class CrearSubastaController {

    private final CrearSubastaService crearSubastaService;
    private final SubastaConverter subastaConverter;


    public CrearSubastaController(CrearSubastaService crearSubastaService, SubastaConverter subastaConverter) {
        this.crearSubastaService = crearSubastaService;
        this.subastaConverter = subastaConverter;
    }

    @PostMapping("")
    public ResponseEntity<WrapperResponse<CrearSubastaDto>> CrearSubasta( @RequestBody CrearSubastaDto crearSubastaDto) {
        Subasta subasta=subastaConverter.fromDTO(crearSubastaDto);
        Subasta SubastaNew = crearSubastaService.crearSubasta(subasta);
        CrearSubastaDto response =subastaConverter.fromEntity(SubastaNew);
        return  new WrapperResponse<CrearSubastaDto>(true,"success",response).createResponse( HttpStatus.CREATED);
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<WrapperResponse<Subasta>> Eliminar(@PathVariable("id") Integer id) {
        Subasta SubastaDeleted = crearSubastaService.eliminarSubasta(id);
        return  new WrapperResponse<Subasta>(true,"success",SubastaDeleted).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{ids}")
    public ResponseEntity<WrapperResponse<List<CrearSubastaDto>>> Listar(@PathVariable("ids") Integer id){
        List<Subasta> subastasList= crearSubastaService.misSubastas(id);
        List<CrearSubastaDto> subastaDtoList=subastaConverter.fromEntity(subastasList);
        return  new WrapperResponse<List<CrearSubastaDto>>(true,"success",subastaDtoList).createResponse(HttpStatus.OK);
    }

    @GetMapping("estados/{ides}/{estado}")
    public ResponseEntity<WrapperResponse<List<CrearSubastaDto>>> ListarEstados(@PathVariable("ides") Integer id, @PathVariable("estado") String estado){
        List<Subasta> subastasList= crearSubastaService.SubsatasEstados(id,estado);
        List<CrearSubastaDto> SubastaListDto= subastaConverter.fromEntity(subastasList);
        return  new WrapperResponse<List<CrearSubastaDto>>(true,"success",SubastaListDto).createResponse(HttpStatus.OK);
    }

}
