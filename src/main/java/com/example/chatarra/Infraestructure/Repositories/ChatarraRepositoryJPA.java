package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.Entitys.Chatarra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatarraRepositoryJPA extends JpaRepository<Chatarra,Integer> {

}
