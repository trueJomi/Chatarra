package com.example.chatarra.Domain.entitys;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Horarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Horario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDate;

    @Column(name = "StartDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDate endDate;

    @Column(name = "DayWeek", nullable = false)
    private LocalDate dayWeek;

    @ManyToOne
    @JoinColumn( name = "idComprador", foreignKey = @ForeignKey(name = "FK_Horario_Comprador"))
    private Comprador comprador;
 }
