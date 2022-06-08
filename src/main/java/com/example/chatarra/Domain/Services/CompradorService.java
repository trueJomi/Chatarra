package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.entitys.Comprador;
import com.example.chatarra.Infraestructure.Repositories.Imp.CompradorRepositoryImp;
import org.springframework.stereotype.Service;

@Service
public class CompradorService {
    private final CompradorRepositoryImp compradorRepositoryImp;
    public CompradorService(CompradorRepositoryImp compradorRepositoryImp){
        this.compradorRepositoryImp=compradorRepositoryImp;
    }
    public Comprador login(String user,String password){
        return compradorRepositoryImp.login(user,password);
    }
    public Comprador buscarPorId(Integer id){
        return compradorRepositoryImp.buscarPorId(id);
    }

}
