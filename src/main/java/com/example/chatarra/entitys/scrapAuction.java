package com.example.chatarra.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subasta_chatarra")
@IdClass(ScrapAuctionPK.class)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class scrapAuction {


    @Id
    private Scrap idScrap;

    @Id
    private Auction idAuction;









}