package com.example.chatarra.entitys;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "cuenta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Integer idAcount;

    @Column(name = "usuario")
    @Size(min = 4, max = 20, message = "Usuario no Valido")
    private String user;

    @Column(name = "contraseña")
    @Size(min = 8, max = 16, message = "contraseña invalida")
    private String password;

    @Column(name = "telefono")
    @Size(min = 9, max = 9, message = "celular no valido")
    private String phone;

    @Column(name = "nombre")
    @Size(min = 2, max = 30, message = "nombre no valido")
    private String name;

    @OneToOne(mappedBy = "account")
    @PrimaryKeyJoinColumn
    private Auction auction;
}
