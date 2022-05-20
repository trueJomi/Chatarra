package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Schedule")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Scrap {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDate

    @Column(name = "StartDate", nullable = false)
    private Date startDate;

    @Column(name = "EndDate", nullable = false)
    private Date endDate;

    @Column(name = "DayWeek", nullable = false)
    private Date dayWeek; 
 }
