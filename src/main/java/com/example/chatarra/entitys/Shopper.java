package com.example.chatarra.entitys;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "compradores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Shopper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idShopper;

    @Column(name = "area")
    private String area;

    @Column( name = "estado")
    private String status;

}
