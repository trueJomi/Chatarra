package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chatarra")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChatarra;
    @Column( name = "tipo",nullable = false)
    private String type;
    @Column( name = "nombre",nullable = false)
    private String name;
    @Column( name = "precioBase",nullable = false)
    private Float basePrice;
    @ManyToOne
    @JoinColumn( name = "idSeller", foreignKey = @ForeignKey(name = "FK_Chatarra_Vendedor"))
    private Seller seller;


}
