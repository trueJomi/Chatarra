package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.entitys.Comprador;
import com.example.chatarra.Domain.entitys.Vendedor;
import com.example.chatarra.Infraestructure.Repositories.Imp.VendedorRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    private final VendedorRepositoryImp vendedorRepositoryImp;

    public VendedorService(VendedorRepositoryImp vendedorRepositoryImp) {
        this.vendedorRepositoryImp = vendedorRepositoryImp;


    }
    public Vendedor login(String user, String password){
        return vendedorRepositoryImp.login(user,password);
    }
    public Vendedor buscarPorId(Integer id){
        return vendedorRepositoryImp.buscarPorId(id);


    }
    public Vendedor crearVendedor(Vendedor vendedor){
        return vendedorRepositoryImp.guardar(vendedor);
    }

    public List<Vendedor> ObtenerVendedores(){
        return vendedorRepositoryImp.obtenerVendedores();
    }
}
