package com.example.chatarra.Infraestructure.Repositories;

import com.example.chatarra.Domain.entitys.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepository extends JpaRepository<Subasta, Integer> {

    @Query("SELECT a FROM  Subasta a WHERE a.status=:estado")
    List<Subasta> FiltrarEstado(@Param("estado") String estado);

}
