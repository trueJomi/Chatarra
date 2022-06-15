package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Infraestructure.Repositories.CompradorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompradorServiceImpl implements CompradorService{
    @Autowired
    private CompradorRepositoryJPA compradorRepositoryJPA;

    @Override
    public Optional<Comprador> login(String user) {
        return compradorRepositoryJPA.findByUser(user);
    }
}