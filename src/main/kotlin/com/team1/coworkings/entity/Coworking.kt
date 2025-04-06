package com.team1.coworkings.entity

import com.team1.coworkings.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "coworking", schema = "coworkings")
data class Coworking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "label", unique = true, nullable = false)
    var label: String,
    @Column(name = "description", nullable = false)
    var description: String,
    @Column(name = "address", nullable = false)
    var address: String,
    @Column(name = "capacity", nullable = false)
    var capacity: Int,
    @Column(name = "openFrom", nullable = false)
    var openFrom: String,
    @Column(name = "openTo", nullable = false)
    var openTo: String,

    @OneToMany(mappedBy = "coworking", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], targetEntity = Booking::class)
    var bookings: List<Booking> = listOf(),
    @OneToMany(mappedBy = "coworking", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], targetEntity = LikedCoworking::class)
    var likedCoworkings: List<LikedCoworking> = listOf(),
    @OneToMany(mappedBy = "coworking", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], targetEntity = CoworkingInventory::class)
    var coworkingInventories: List<CoworkingInventory> = listOf()
) : BaseEntity {
    override fun getPk (): Long {
        return id
    }
}
