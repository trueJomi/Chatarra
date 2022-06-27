package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Domain.RepositoryContracts.CompradorRepository;
import com.example.chatarra.Domain.RepositoryContracts.PropuestaRepository;
import com.example.chatarra.Domain.RepositoryContracts.SubastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropuestaService {

    private PropuestaRepository propuestaRepository;
    private CompradorRepository compradorRepository;
    private SubastaRepository subastaRepository;

    public PropuestaService(PropuestaRepository propuestaRepository, CompradorRepository compradorRepository, SubastaRepository subastaRepository) {
        this.propuestaRepository = propuestaRepository;
        this.compradorRepository = compradorRepository;
        this.subastaRepository = subastaRepository;
    }

    public Propuesta crearPropuesta(Propuesta propuesta){

        Comprador comprador = compradorRepository.buscarPorId(propuesta.getComprador().getIdShopper());
        Subasta subasta = subastaRepository.buscarPorId(propuesta.getSubasta().getIdSubasta());

        propuesta.setComprador(comprador);
        propuesta.setSubasta(subasta);
        propuesta.setTime(LocalDateTime.now());

        return propuestaRepository.GuardarPropuesta(propuesta);
    }

    public List<Propuesta> propuestaPorSubasta(Integer id){
        return propuestaRepository.PropuestaPorSubastas(id);
    }

    public List<Propuesta> propuestaPorUser(Integer id){
        return propuestaRepository.PropuestasPorUSer(id);
    }

    public Propuesta BuscarPorId(Integer id){
        return propuestaRepository.BuscarPorId(id);
    }

    public Propuesta PropuestaMayor(Integer id){
        List<Propuesta> propuestas = propuestaRepository.PropuestaPorSubastas(id);
        if (propuestas.size()==0){
            return null;
        }
        Propuesta mayor= propuestas.get(0);
        for(int i=1; i <propuestas.size();i++){
            if(propuestas.get(i).getPrice()> mayor.getPrice()){
                mayor=propuestas.get(i);
            }
        }
        return mayor;
    }
}
