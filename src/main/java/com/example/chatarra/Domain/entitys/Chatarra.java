package com.example.chatarra.Domain.entitys;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chatarra")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Chatarra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChatarra;

    @Column( name = "nombre",nullable = false)
    private String name;

    @Column( name = "descripcion",nullable = false)
    private String description;


    @Column( name = "precioBase",nullable = false)
    private Float basePrice;

    @OneToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Chatarra_Vendedor"))
    private Vendedor vendedor;

    @OneToOne(mappedBy = "chatarra",cascade = {CascadeType.ALL})
    private Subasta subasta;
}
