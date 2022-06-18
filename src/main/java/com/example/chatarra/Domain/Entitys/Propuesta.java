package com.example.chatarra.Domain.Entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "propuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Propuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;

    @Column( name = "precio",nullable = false)
    private Float price;

    @Column( name = "tiempo",nullable = false)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn( name = "idSubasta", foreignKey = @ForeignKey(name = "FK_Propuestas_Subasta"))
    private Subasta subasta;

    @ManyToOne
    @JoinColumn( name = "idShopper", foreignKey = @ForeignKey(name = "FK_Propuestas_Comprador"))
    private Comprador comprador;

}