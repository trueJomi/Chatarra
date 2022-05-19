package com.example.chatarra.entitys;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "Pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class  Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPayment;

    @Column(name = "Method", nullable = false)
    private String method;

    @Column(name = "Price", nullable = false)
    private Float price;

    @OneToOne
    @JoinColumn( name = "idAuction", foreignKey = @ForeignKey(name = "FK_Subasta_pago"))
    private Auction auction;
}

