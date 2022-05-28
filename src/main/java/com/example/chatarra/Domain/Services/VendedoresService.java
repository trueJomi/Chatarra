package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.entitys.Vendedor;
import com.example.chatarra.Infraestructure.Repositories.Imp.SubastaRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.VendedorRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedoresService {

    private final VendedorRepositoryImp vendedorRepositoryImp;

    public VendedoresService(VendedorRepositoryImp vendedorRepositoryImp) {
        this.vendedorRepositoryImp = vendedorRepositoryImp;
    }

    public Vendedor crearVendedor(Vendedor vendedor){
        return vendedorRepositoryImp.guardar(vendedor);
    }

    public List<Vendedor> ObtenerVendedores(){
        return vendedorRepositoryImp.obtenerVendedores();
    }

}
