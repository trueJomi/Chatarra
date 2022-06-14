package com.example.chatarra.Infraestructure.Repositories;


import com.example.chatarra.Domain.RepositoryContracts.VendedorRepository;
import com.example.chatarra.Domain.entitys.Comprador;
import com.example.chatarra.Domain.entitys.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositoryJPA extends JpaRepository<Vendedor, Integer> {
    Vendedor findByUserAndPassword(String user, String password);
    Vendedor findByIdVendedor(Integer id);

}
