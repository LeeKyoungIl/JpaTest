package com.daumkakao.jpa.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by kellin on 9/7/15.
 */
@Entity
@Table(name = "ITEM")
class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    Long id

    String name
    int price
    int stockQuantity
}
