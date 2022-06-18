package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Infraestructure.Repositories.Imp.CompradorRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.PropuestaRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.SubastaRepositoryImp;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class PropuestaService {
    private final PropuestaRepositoryImp propuestaRepositoryImp;
    private final SubastaRepositoryImp subastaRepositoryImp;

    private final CompradorRepositoryImp compradorRepositoryImp;

    public PropuestaService(PropuestaRepositoryImp propuestaRepositoryImp, SubastaRepositoryImp subastaRepositoryImp, CompradorRepositoryImp compradorRepositoryImp){
        this.propuestaRepositoryImp = propuestaRepositoryImp;
        this.subastaRepositoryImp = subastaRepositoryImp;
        this.compradorRepositoryImp = compradorRepositoryImp;
    }

    @Transactional
    public Propuesta crearPropuesta(Propuesta propuesta){
        Subasta newSubasta = subastaRepositoryImp.buscarPorId(propuesta.getSubasta().getIdSubasta());
        Comprador newComprador = compradorRepositoryImp.buscarPorId(propuesta.getComprador().getIdShopper());
        propuesta.setTime(LocalDate.now());
        propuesta.setSubasta(newSubasta);
        propuesta.setComprador(newComprador);
        Propuesta newPropuesta = propuestaRepositoryImp.guardar(propuesta);
        return newPropuesta;
    }

}
