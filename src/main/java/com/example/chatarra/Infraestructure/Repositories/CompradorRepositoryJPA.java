package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.entitys.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompradorRepositoryJPA extends JpaRepository<Comprador,Integer> {
    public Optional<Comprador> findByUser(String user);

}