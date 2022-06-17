package com.example.chatarra.Domain.Entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "subastas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Subasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubasta;

    @Column( name = "fecha",nullable = false)
    private LocalDate fecha;

    @Column( name = "tiempoRecojo" )
    private LocalDate FechaRecojo;

    @Column( name = "estado", nullable = false)
    private String status;

    @Column( name = "PropuestaSelccionada")
    private Integer Sleccionado;

    @OneToMany(mappedBy = "subasta",cascade = {CascadeType.ALL})
    private List<Propuesta> Propuestas;

    @ManyToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Subasta_Vendedor"),nullable = false)
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "idChatarra",foreignKey = @ForeignKey(name = "FK_Subasta_Chatarra"))
    private Chatarra chatarra;

}