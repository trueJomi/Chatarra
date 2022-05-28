package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.entitys.Comprador;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CompradorService {
    public Optional<Comprador> login(String user);

}