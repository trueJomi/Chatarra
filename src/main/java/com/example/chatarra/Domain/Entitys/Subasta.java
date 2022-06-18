package com.example.chatarra.Domain.Entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    private LocalDateTime fecha;

    @Column( name = "tiempoRecojo" )
    private LocalDateTime FechaRecojo;

    @Column( name = "estado", nullable = false)
    private String status;

    @Column( name = "PropuestaSeleccionada")
    private Integer seleccionado;

    @OneToMany(mappedBy = "subasta",cascade = {CascadeType.ALL})
    private List<Propuesta> propuestas;

    @ManyToOne
    @JoinColumn( name = "idVendedor", foreignKey = @ForeignKey(name = "FK_Subasta_Vendedor"),nullable = false)
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "idChatarra",foreignKey = @ForeignKey(name = "FK_Subasta_Chatarra"))
    private Chatarra chatarra;

}