package com.daumkakao.jpa.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

/**
 * Created by kellin on 9/8/15.
 */
@Entity
@Table(name = "CATEGORY")
class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    Long id

    String name

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    List<Item> items = new ArrayList<>()

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    Category parent

    @OneToMany(mappedBy = "parent")
    List<Category> child = new ArrayList<>()

    void addChildCategory (Category child) {
        this.child.add(child)
        child.parent = this
    }

    void addItem (Item item) {
        items.add(item)
    }
}
