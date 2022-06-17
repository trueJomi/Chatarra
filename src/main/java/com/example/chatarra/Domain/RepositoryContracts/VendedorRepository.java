package com.example.chatarra.Domain.RepositoryContracts;

import com.example.chatarra.Domain.Entitys.Comprador;
import com.example.chatarra.Domain.Entitys.Vendedor;

import java.util.List;

public interface VendedorRepository {

    Vendedor guardar(Vendedor vendedor);

    List<Vendedor> obtenerVendedores();

    Vendedor login(String user, String password);
    Vendedor buscarPorId(Integer id);
}
