package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.entitys.Subasta;
import com.example.chatarra.Infraestructure.Repositories.Imp.SubastaRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class CrearSubastaService {


    private  final SubastaRepositoryImp subastaRepositoryImp;


    public CrearSubastaService(SubastaRepositoryImp subastaRepositoryImp) {
        this.subastaRepositoryImp = subastaRepositoryImp;
    }

    @Transactional
    public Subasta crearSubasta(Subasta subasta){
        subasta.setStatus("activo");
        subasta.setDate(LocalDate.now());
        return subastaRepositoryImp.guardar(subasta);
    }

    @Transactional
    public Subasta eliminarSubasta(Integer id){
        Subasta temp= subastaRepositoryImp.buscarPorId(id);
        temp.setStatus("cancelado");
        return subastaRepositoryImp.guardar(temp);
    }

    @Transactional
    public Subasta editarSubasta(Subasta subasta){
        return subastaRepositoryImp.guardar(subasta);
    }

    public List<Subasta> misSubastas( Integer id){
        return subastaRepositoryImp.ListarPorUsuario(id);
    }

}
