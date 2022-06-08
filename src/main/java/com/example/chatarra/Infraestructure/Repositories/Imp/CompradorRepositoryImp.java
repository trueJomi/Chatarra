package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Domain.RepositoryContracts.CompradorRepository;
import com.example.chatarra.Domain.entitys.Comprador;
import com.example.chatarra.Infraestructure.Repositories.CompradorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompradorRepositoryImp implements CompradorRepository {

    @Autowired
    CompradorRepositoryJPA db;

    @Override
    public Comprador login(String user, String password) {
        return db.findByUserAndPassword(user,password);
    }

    @Override
    public Comprador buscarPorId(Integer id) {
        return db.findByIdShopper(id);
    }
}
