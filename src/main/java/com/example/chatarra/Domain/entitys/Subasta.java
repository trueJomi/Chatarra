package com.example.chatarra.Domain.entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
    private Integer idSubasta;

    @Column( name = "fecha",nullable = false)
    private LocalDate date;

    @Column( name = "tiempoRecojo" )
    private LocalDate pickUpDate;

    @Column( name = "estado", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Subasta_Vendedor"),nullable = false)
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "idChatarra",foreignKey = @ForeignKey(name = "FK_Subasta_Chatarra"),nullable = false)
    private Chatarra chatarra;

}