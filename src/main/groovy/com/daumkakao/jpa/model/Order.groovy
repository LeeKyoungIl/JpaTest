package com.daumkakao.jpa.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by kellin on 9/7/15.
 */
@Entity
@Table(name = "ORDERS")
class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    Long id

    String orderName

    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    Member member

    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>()

    void setMember (Member member) {
        // 기존 관계 제거
        if (this.member != null) {
            this.member.orders.remove(this)
        }

        this.member = member
        member.orders.add(this)
    }

    void addOrderItem (OrderItem orderItem) {
        orderItems.add(orderItem)
        orderItem.order = this
    }
}
