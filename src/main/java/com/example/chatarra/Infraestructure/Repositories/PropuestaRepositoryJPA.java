package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.Entitys.Propuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropuestaRepositoryJPA extends JpaRepository<Propuesta,Integer> {

    @Query("SELECT p FROM Propuesta p WHERE p.subasta.idSubasta=:id")
    List<Propuesta> BuscarPropuestasPorSubasta(@Param("id") Integer id);

    @Query("SELECT p FROM Propuesta p WHERE p.comprador.idShopper=:id")
    List<Propuesta> BuscarPropuestasPorUsuario(@Param("id")Integer id);
}
