package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.Entitys.Comprador;

import java.util.List;

public interface CompradorRepository {
    Comprador login(String user, String password);
    Comprador buscarPorId(Integer id);
}
