package com.team1.coworkings.entity

import com.team1.coworkings.base.BaseEntity
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "booking", schema = "coworkings")
data class Booking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "dateFrom", nullable = false)
    var dateFrom: Date,
    @Column(name = "dateTo", nullable = false)
    var dateTo: Date,
    @Column(name = "personsAmount", nullable = false)
    var personsAmount: Int = 0,

    @ManyToOne
    @JoinColumn(name = "coworkingId", referencedColumnName = "id")
    var coworking: Coworking,
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    var user: User
) : BaseEntity {
    override fun getPk(): Long {
        return id
    }
}
