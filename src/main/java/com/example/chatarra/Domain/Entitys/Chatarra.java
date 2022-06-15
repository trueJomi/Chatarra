package com.example.chatarra.Domain.Entitys;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chatarra")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Chatarra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChatarra;

    @Column( name = "titulo",nullable = false)
    private String titulo;

    @Column( name = "descripcion",nullable = false)
    private String description;


    @Column( name = "precioBase",nullable = false)
    private Float precioBase;

    @ManyToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Chatarra_Vendedor"))
    private Vendedor vendedor;

    @OneToOne(mappedBy = "chatarra",cascade = {CascadeType.ALL})
    private Subasta subasta;
}
