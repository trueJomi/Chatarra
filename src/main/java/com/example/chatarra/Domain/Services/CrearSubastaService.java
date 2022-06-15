package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Chatarra;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Domain.Entitys.Vendedor;
import com.example.chatarra.Infraestructure.Repositories.Imp.ChatarraRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.SubastaRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.VendedorRepositoryImp;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class CrearSubastaService {

    private final SubastaRepositoryImp subastaRepositoryImp;

    private final ChatarraRepositoryImp chatarraRepositoryImp;

    private final VendedorRepositoryImp vendedorRepositoryImp;

    public CrearSubastaService(SubastaRepositoryImp subastaRepositoryImp, ChatarraRepositoryImp chatarraRepositoryImp, VendedorRepositoryImp vendedorRepositoryImp) {
        this.subastaRepositoryImp = subastaRepositoryImp;
        this.chatarraRepositoryImp = chatarraRepositoryImp;
        this.vendedorRepositoryImp = vendedorRepositoryImp;
    }


    @Transactional
    public Subasta crearSubasta(Subasta subasta){
        Vendedor newVendedor=vendedorRepositoryImp.buscarPorId(subasta.getVendedor().getIdVendedor());
        subasta.setVendedor(newVendedor);
        subasta.setStatus("activo");
        subasta.setFecha(LocalDate.now());
        Subasta newSubasta=subastaRepositoryImp.guardar(subasta);
        Chatarra newChatarra=newSubasta.getChatarra();
        newChatarra.setSubasta(newSubasta);
        chatarraRepositoryImp.guardar(newChatarra);
        return newSubasta;
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

    public List<Subasta> SubsatasEstados(Integer id,String estado){
        return subastaRepositoryImp.FiltrarEstadoUsuario(estado,id);
    }

}
