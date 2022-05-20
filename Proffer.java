package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "propuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Proffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;
    @Column( name = "precio",nullable = false)
    private String price;
    @Column( name = "tiempo",nullable = false)
    private DateTime time;
    @ManyToOne
    @JoinColumn( name = "idAuction", foreignKey = @ForeignKey(name = "FK_Propuestas_Subasta"))
    private Auction auction;
    @ManyToOne
    @JoinColumn( name = "idShopper", foreignKey = @ForeignKey(name = "FK_Propuestas_Comprador"))
    private Shopper shopper

}