package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.entitys.Vendedor;

import java.util.List;

public interface VendedorRepository {

    Vendedor guardar(Vendedor vendedor);

    List<Vendedor> obtenerVendedores();
}
