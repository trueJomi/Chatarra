package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.RepositoryContracts.PropuestaRepository;
import com.example.chatarra.Infraestructure.Repositories.PropuestaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropuestaRepositoryImp implements PropuestaRepository {
    @Autowired
    PropuestaRepositoryJPA db;

    @Override
    public Propuesta guardar(Propuesta propuesta){
        return db.save(propuesta);
    }
}
