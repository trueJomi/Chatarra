package com.example.chatarra.entitys;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class auctionShopperPK implements Serializable {

    @ManyToOne
    @JoinColumn( name = "idAuction", nullable = false)
    private Auction idAuction;

    @ManyToOne
    @JoinColumn( name = "idShopper", nullable = false)
    private Shopper idShopper;
}
