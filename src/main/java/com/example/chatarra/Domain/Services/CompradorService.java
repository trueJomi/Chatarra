package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Comprador;

import java.util.Optional;


public interface CompradorService {
    public Optional<Comprador> login(String user);

}