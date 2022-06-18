package com.example.chatarra.Domain.Entitys;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPayment;

    @Column(name = "Method", nullable = false)
    private String method;

    @Column(name = "Price", nullable = false)
    private Float price;

    @OneToOne
    @JoinColumn( name = "idSubasta", foreignKey = @ForeignKey(name = "FK_Subasta_pago"))
    private Subasta subasta;
}

