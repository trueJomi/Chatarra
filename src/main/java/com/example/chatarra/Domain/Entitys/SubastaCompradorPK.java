package com.example.chatarra.Domain.Entitys;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class SubastaCompradorPK implements Serializable {

    @ManyToOne
    @JoinColumn( name = "idAuction", nullable = false)
    private Subasta idSubasta;

    @ManyToOne
    @JoinColumn( name = "idShopper", nullable = false)
    private Comprador idComprador;
}
