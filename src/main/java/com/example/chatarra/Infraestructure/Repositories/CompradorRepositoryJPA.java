package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.Entitys.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompradorRepositoryJPA extends JpaRepository<Comprador,Integer> {
    Comprador findByUserAndPassword(String user,String password);

    Comprador findByIdShopper(Integer id);
}