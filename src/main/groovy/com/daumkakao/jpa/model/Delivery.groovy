package com.daumkakao.jpa.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

/**
 * Created by kellin on 9/8/15.
 */
@Entity
@Table(name = "DELIVERY")
class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DELIVERY_ID")
    Long id

    @OneToOne(mappedBy = "delivery")
    Order order

    String city
    String street
    String zipcode

    @Enumerated(EnumType.STRING)
    DeliveryStatus status
}
