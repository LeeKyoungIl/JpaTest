package com.daumkakao.jpa.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * Created by kellin on 9/7/15.
 */
@Entity
@Table(name = "MEMBER")
class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    Long id

    String name
    String city
    String street
    String zipcode

    @OneToMany(mappedBy = "member")
    List<Order> orders = new ArrayList<>()
}
