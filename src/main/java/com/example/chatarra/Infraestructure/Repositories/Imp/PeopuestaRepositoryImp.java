package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Aplication.exception.ResourceNotFoundException;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.RepositoryContracts.PropuestaRepository;
import com.example.chatarra.Domain.Services.PropuestaService;
import com.example.chatarra.Infraestructure.Repositories.PropuestaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopuestaRepositoryImp implements PropuestaRepository {

    @Autowired
    PropuestaRepositoryJPA db;

    @Override
    public Propuesta GuardarPropuesta(Propuesta propuesta) {
        return db.save(propuesta);
    }

    @Override
    public List<Propuesta> PropuestaPorSubastas(Integer id) {
        return db.BuscarPropuestasPorSubasta(id);
    }

    @Override
    public List<Propuesta> PropuestasPorUSer(Integer id) {
        return db.BuscarPropuestasPorUsuario(id);
    }

    @Override
    public Propuesta BuscarPorId(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe esta la propuesta: "+id));
    }

}
