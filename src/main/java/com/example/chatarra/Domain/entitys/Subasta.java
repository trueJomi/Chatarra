package com.example.chatarra.Domain.entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "subastas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuction;

    @Column( name = "fecha",nullable = false)
    private LocalDateTime date;

    @Column( name = "tiempoRecojo" )
    private LocalDateTime pickUpDate;

    @Column( name = "estado", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Subasta_Vendedor"))
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "idChatarra",foreignKey = @ForeignKey(name = "FK_Subasta_Chatarra"))
    private Chatarra chatarra;

}