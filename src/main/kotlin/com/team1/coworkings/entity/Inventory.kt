package com.team1.coworkings.entity

import com.team1.coworkings.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "inventory", schema = "coworkings")
data class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "label", unique = true, nullable = false)
    var label: String,
    @Column(name = "description", nullable = false)
    var description: String,

    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], targetEntity = CoworkingInventory::class)
    var coworkingInventories: List<CoworkingInventory> = listOf()
) : BaseEntity {
    override fun getPk(): Long {
        return id
    }
}
