package com.daumkakao.jpa.model

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.ManyToMany
import javax.persistence.Table

/**
 * Created by kellin on 9/7/15.
 */
@Entity
// 상속 관계 맵핑 전략은 단일 테이블 전략 사용.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 단일 테이블 전략은 구분자를 필수로 사용해야 한다.
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "ITEM")
class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID")
    Long id

    String name
    int price
    int stockQuantity

    @ManyToMany(mappedBy = "items")
    List<Category> categories = new ArrayList<>()
}
