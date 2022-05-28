package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.entitys.Subasta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepository {

    Subasta guardar(Subasta subasta);

    void eliminarporId(Integer id);

    Subasta buscarPorId(Integer id);

    List<Subasta> FiltrarEstado( String estado);


    List<Subasta> ListarPorUsuario(Integer id );

    List<Subasta> FiltrarEstadoUsuario(String estado,String usuario);
}
