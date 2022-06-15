package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Domain.RepositoryContracts.VendedorRepository;
import com.example.chatarra.Domain.Entitys.Vendedor;
import com.example.chatarra.Aplication.exception.ResourceNotFoundException;
import com.example.chatarra.Infraestructure.Repositories.VendedorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendedorRepositoryImp implements VendedorRepository {

    @Autowired
    VendedorRepositoryJPA db;


    @Override
    public Vendedor guardar(Vendedor vendedor) {
        return db.save(vendedor);
    }

    @Override
    public List<Vendedor> obtenerVendedores() {
        return db.findAll();
    }

    @Override
    public Vendedor BuscarPorUsuario(String user) {
        return db.findByUser(user);
    }

    public Vendedor buscarPorId(Integer id){
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe este id:"+id));
    }
}
