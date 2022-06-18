package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.Entitys.Propuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropuestaRepositoryJPA extends JpaRepository<Propuesta,Integer> {
}
