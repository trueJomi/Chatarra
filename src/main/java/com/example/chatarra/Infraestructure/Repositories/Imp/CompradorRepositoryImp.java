package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Domain.RepositoryContracts.CompradorRepository;
import com.example.chatarra.Infraestructure.Repositories.CompradorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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


    public Comprador registrarComprador(Comprador comprador) {
        return db.save(comprador);
    }


    public Comprador modificarComprador(Comprador comprador) {
        return db.save(comprador);
    }


    public List<Comprador> listarCompradores() {
        return db.findAll();
    }


    public void eliminarComprador(Integer id) {
        db.deleteById(id);

    }
}
