package com.example.chatarra.Domain.entitys;

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
public class Vendedor {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idVendedor;

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

    @Column(name = "región")
    @Size(min = 4, max=15, message = "region no valida")
    private String region;

    @Column(name = "ciudad")
    @Size(min = 4, max=20, message = "ciudad no valida")
    private String ciudad;

    @Column(name = "distrito")
    @Size(min = 4, max=20, message = "distrito no valida")
    private String distrito;

    @Column(name = "dirección")
    @Size(min = 4, max=50, message = "dirección no valida")
    private String direccion;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor",cascade = {CascadeType.ALL})
    private List<Subasta> subasta;

    @OneToOne(mappedBy = "vendedor",cascade = {CascadeType.ALL})
    private Chatarra chatarra;
}
