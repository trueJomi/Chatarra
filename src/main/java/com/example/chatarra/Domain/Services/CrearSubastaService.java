package com.example.chatarra.Domain.Services;

import com.example.chatarra.Domain.Entitys.Chatarra;
import com.example.chatarra.Domain.Entitys.Propuesta;
import com.example.chatarra.Domain.Entitys.Subasta;
import com.example.chatarra.Domain.Entitys.Vendedor;
import com.example.chatarra.Domain.RepositoryContracts.ChatarraRepository;
import com.example.chatarra.Domain.RepositoryContracts.SubastaRepository;
import com.example.chatarra.Domain.RepositoryContracts.VendedorRepository;
import com.example.chatarra.Infraestructure.Repositories.Imp.ChatarraRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.SubastaRepositoryImp;
import com.example.chatarra.Infraestructure.Repositories.Imp.VendedorRepositoryImp;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CrearSubastaService {

    private final SubastaRepository subastaRepository;

    private final ChatarraRepository chatarraRepository;

    private final VendedorRepository vendedorRepository;

    public CrearSubastaService(SubastaRepository subastaRepository, ChatarraRepository chatarraRepository, VendedorRepository vendedorRepository) {
        this.subastaRepository = subastaRepository;
        this.chatarraRepository = chatarraRepository;
        this.vendedorRepository = vendedorRepository;
    }

    @Transactional
    public Subasta crearSubasta(Subasta subasta){
        Vendedor newVendedor=vendedorRepository.buscarPorId(subasta.getVendedor().getIdVendedor());
        subasta.setVendedor(newVendedor);
        subasta.setStatus("activo");
        subasta.setFecha(LocalDateTime.now());
        List<Propuesta> propuestas = new ArrayList<Propuesta>();
        subasta.setPropuestas(propuestas);
        Subasta newSubasta=subastaRepository.guardar(subasta);
        Chatarra newChatarra=newSubasta.getChatarra();
        newChatarra.setVendedor(newVendedor);
        newChatarra.setSubasta(newSubasta);
        chatarraRepository.guardar(newChatarra);
        return newSubasta;
    }

    @Transactional
    public Subasta eliminarSubasta(Integer id){
        Subasta temp= subastaRepository.buscarPorId(id);
        temp.setStatus("cancelado");
        return subastaRepository.guardar(temp);
    }

    @Transactional
    public Subasta editarSubasta(Subasta subasta){
        Vendedor newVendedor=vendedorRepository.buscarPorId(subasta.getVendedor().getIdVendedor());
        subasta.setVendedor(newVendedor);
        subasta.setStatus("activo");
        subasta.setFecha(LocalDateTime.now());
        List<Propuesta> propuestas = new ArrayList<Propuesta>();
        subasta.setPropuestas(propuestas);
        Subasta newSubasta=subastaRepository.guardar(subasta);
        Chatarra newChatarra=newSubasta.getChatarra();
        newChatarra.setDescription(subasta.getChatarra().getDescription());
        newChatarra.setTitulo(subasta.getChatarra().getTitulo());
        newChatarra.setPrecioBase(subasta.getChatarra().getPrecioBase());
        newChatarra.setVendedor(newVendedor);
        newChatarra.setSubasta(newSubasta);
        chatarraRepository.guardar(newChatarra);

        return subastaRepository.guardar(subasta);
    }

    public List<Subasta> misSubastas( Integer id){
        return subastaRepository.ListarPorUsuario(id);
    }

    public List<Subasta> SubsatasEstados(Integer id,String estado){
        return subastaRepository.FiltrarEstadoUsuario(estado,id);
    }

    public Subasta buscarPorId( Integer id){
        return subastaRepository.buscarPorId(id);
    }

    public List<Subasta> FiltrarSubastasPorEstado(String estado){
        return subastaRepository.FiltrarEstado(estado);
    }
}
