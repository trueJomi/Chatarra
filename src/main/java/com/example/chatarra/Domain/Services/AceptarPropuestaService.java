package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Domain.RepositoryContracts.PropuestaRepository;
import com.example.chatarra.Domain.RepositoryContracts.SubastaRepository;
import org.springframework.stereotype.Service;


@Service
public class AceptarPropuestaService {

    private SubastaRepository subastaRepository;

    private PropuestaRepository propuestaRepository;

    public AceptarPropuestaService(SubastaRepository subastaRepository, PropuestaRepository propuestaRepository) {
        this.subastaRepository = subastaRepository;
        this.propuestaRepository = propuestaRepository;
    }

    public Subasta aceptarPropuesta(Integer idSubasta, Integer idPropuesta){


        Subasta subasta= subastaRepository.buscarPorId(idSubasta);
        Propuesta propuesta= propuestaRepository.BuscarPorId(idPropuesta);

        subasta.setSeleccionado(propuesta.getIdPropuesta());
        subasta.setStatus("aceptado");


        return subastaRepository.guardar(subasta);
    }

    public Subasta cancelarAceptacion(Integer idSubasta){
        Subasta subasta= subastaRepository.buscarPorId(idSubasta);
        subasta.setSeleccionado(null);
        subasta.setStatus("activo");
        return subastaRepository.guardar(subasta);
    }


}
