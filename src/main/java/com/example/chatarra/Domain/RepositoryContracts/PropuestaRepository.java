package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.Entitys.Propuesta;

import java.util.List;

public interface PropuestaRepository {
    Propuesta GuardarPropuesta(Propuesta propuesta);

    List<Propuesta> PropuestaPorSubastas(Integer id);

    List<Propuesta> PropuestasPorUSer(Integer id);

    Propuesta BuscarPorId(Integer id);

}
