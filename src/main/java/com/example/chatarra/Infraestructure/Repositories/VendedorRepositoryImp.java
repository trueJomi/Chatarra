package com.example.chatarra.Infraestructure.Repositories;


import com.example.chatarra.Domain.RepositoryContracts.VendedorRepository;
import com.example.chatarra.Domain.entitys.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VendedorRepositoryImp extends JpaRepository<Vendedor, Integer>, VendedorRepository {

    @Override
    default Vendedor guardar(Vendedor vendedor) {
        return save(vendedor);
    }

    @Override
    default Vendedor obtenerPorId(Integer id) {
        return getById(id);
    }
}
