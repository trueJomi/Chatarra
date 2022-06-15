package com.example.chatarra.Infraestructure.Repositories;


import com.example.chatarra.Domain.Entitys.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositoryJPA extends JpaRepository<Vendedor, Integer> {

    Vendedor findByUser(String user);
}
