package com.daumkakao.jpa.model

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by kellin on 9/7/15.
 */
@Entity
@Table(name = "ORDERS")
class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    Long id

    String orderName

    @Temporal(TemporalType.TIMESTAMP)
    Date orderDate

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    Member member

    // OneToMany, ManyToMany 의 경우 기본 전략이 Lazy 로딩이다.
    // 주문한 상품들의 경우 영속성 정의를 설정해서 영속 상태로 쉽게 만들어 준다.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>()

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    Delivery delivery

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

    void setDelivery (Delivery delivery) {
        this.delivery = delivery
        delivery.setOrder(this)
    }
}
