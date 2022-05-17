package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "vendedores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seller {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idSeller;

    @Column(name = "región")
    @Size(min = 4, max=15, message = "region no valida")
    private String region;

    @Column(name = "ciudad")
    @Size(min = 4, max=20, message = "ciudad no valida")
    private String city;

    @Column(name = "distrito")
    @Size(min = 4, max=20, message = "distrito no valida")
    private String district;

    @Column(name = "dirección")
    @Size(min = 4, max=50, message = "dirección no valida")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "seller",cascade = {CascadeType.ALL})
    private List<Auction> auction;
}
