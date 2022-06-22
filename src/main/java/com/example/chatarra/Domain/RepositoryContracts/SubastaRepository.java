package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.Entitys.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubastaRepository {

    Subasta guardar(Subasta subasta);

    void eliminarporId(Integer id);

    Subasta buscarPorId(Integer id);

    List<Subasta> FiltrarEstado( String estado);


    List<Subasta> ListarPorUsuario(Integer id );

    List<Subasta> FiltrarEstadoUsuario(String estado,Integer id);
}
