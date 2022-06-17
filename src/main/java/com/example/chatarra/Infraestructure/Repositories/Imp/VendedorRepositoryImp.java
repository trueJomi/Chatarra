package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Domain.RepositoryContracts.VendedorRepository;
import com.example.chatarra.Domain.Entitys.Vendedor;
import com.example.chatarra.Infraestructure.Repositories.VendedorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendedorRepositoryImp implements VendedorRepository {

    @Autowired
    VendedorRepositoryJPA db;

    @Override
    public Vendedor login(String user, String password) {
        return db.findByUserAndPassword(user,password);
    }

    @Override
    public Vendedor buscarPorId(Integer id) {
        return db.findByIdVendedor(id);
    }
}
