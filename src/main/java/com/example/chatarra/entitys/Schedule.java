package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Schedule {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDate;

    @Column(name = "StartDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDate endDate;

    @Column(name = "DayWeek", nullable = false)
    private LocalDate dayWeek;
 }
