package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Auction {
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
    @JoinColumn( name = "idSeller", foreignKey = @ForeignKey(name = "FK_Subasta_Vendedor"))
    private Seller seller;
}
