package com.example.chatarra.Domain.Entitys;

import lombok.*;

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
@Builder
public class SubastaComprador {

    @Id
    private Subasta idSubasta;

    @Id
    private Comprador idComprador;
}
