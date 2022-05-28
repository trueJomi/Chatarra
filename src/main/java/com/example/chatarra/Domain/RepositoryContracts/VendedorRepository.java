package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.entitys.Vendedor;

public interface VendedorRepository {

    Vendedor guardar(Vendedor vendedor);

    Vendedor obtenerPorId(Integer id);
}
