package com.example.chatarra.Domain.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "subastaComprador")
@NoArgsConstructor
@IdClass(SubastaCompradorPK.class)
@AllArgsConstructor
@Getter
@Setter
public class SubastaComprador {

    @Id
    private Subasta idSubasta;

    @Id
    private Comprador idComprador;
}
