package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.Entitys.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreregistrationRepositoryJPA extends JpaRepository<Comprador,Integer>{
}
