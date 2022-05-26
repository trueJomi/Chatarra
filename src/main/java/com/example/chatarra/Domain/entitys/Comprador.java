package com.example.chatarra.Domain.entitys;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "compradores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idShopper;

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

    @Column(name = "area")
    private String area;

    @Column( name = "estado")
    private String status;

    @OneToMany(mappedBy = "comprador",cascade = {CascadeType.ALL})
    private List<Horario> horario;

    @OneToMany(mappedBy = "comprador",cascade = {CascadeType.ALL})
    private List<Propuesta> propuestas;
}
