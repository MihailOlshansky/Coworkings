package com.team1.coworkings.entity

import com.team1.coworkings.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "coworking_inventory", schema = "coworkings")
data class CoworkingInventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "amount", nullable = false)
    var amount: Int = 0,

    @ManyToOne
    @JoinColumn(name = "coworkingId", referencedColumnName = "id")
    var coworking: Coworking,
    @ManyToOne
    @JoinColumn(name = "inventoryId", referencedColumnName = "id")
    var inventory: Inventory
) : BaseEntity {
    override fun getPk(): Long {
        return id
    }
}
