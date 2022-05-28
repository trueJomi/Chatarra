package com.example.chatarra.Domain.entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "propuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Propuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;

    @Column( name = "precio",nullable = false)
    private String price;

    @Column( name = "tiempo",nullable = false)
    private LocalDate time;

    @ManyToOne
    @JoinColumn( name = "idAuction", foreignKey = @ForeignKey(name = "FK_Propuestas_Subasta"))
    private Subasta subasta;

    @ManyToOne
    @JoinColumn( name = "idShopper", foreignKey = @ForeignKey(name = "FK_Propuestas_Comprador"))
    private Comprador comprador;

}