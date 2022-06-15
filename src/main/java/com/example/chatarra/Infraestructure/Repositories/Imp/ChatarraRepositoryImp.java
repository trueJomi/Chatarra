package com.example.chatarra.Infraestructure.Repositories.Imp;

import com.example.chatarra.Domain.RepositoryContracts.ChatarraRepository;
import com.example.chatarra.Domain.Entitys.Chatarra;
import com.example.chatarra.Infraestructure.Repositories.ChatarraRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatarraRepositoryImp implements ChatarraRepository {

    @Autowired
    ChatarraRepositoryJPA db;


    @Override
    public Chatarra guardar(Chatarra chatarra) {
        return db.save(chatarra);
    }
}
