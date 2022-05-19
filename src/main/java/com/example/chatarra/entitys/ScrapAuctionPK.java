package com.example.chatarra.entitys;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ScrapAuctionPK implements Serializable {

    @ManyToOne
    @JoinColumn( name = "idScrap", nullable = false)
    private Scrap idScrap;

    @ManyToOne
    @JoinColumn( name = "idAuction", nullable = false)
    private Auction idAuction;
}