package com.example.chatarra.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "subastaComprador")
@NoArgsConstructor
@IdClass(auctionShopperPK.class)
@AllArgsConstructor
@Getter
@Setter
public class auctionShopper {

    @Id
    private Auction idAuction;

    @Id
    private Shopper idShopper;
}
