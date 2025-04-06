package com.team1.coworkings.entity

import com.team1.coworkings.base.BaseEntity
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "liked_coworking", schema = "coworkings")
data class LikedCoworking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "likeDate", nullable = false)
    var likeDate: Date,

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
