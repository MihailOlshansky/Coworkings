package com.team1.coworkings.entity

import com.team1.coworkings.base.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "role", schema = "coworkings")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "code", unique = true, nullable = false)
    var code: String,

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], targetEntity = User::class)
    private val users: Set<User> = emptySet()
) : BaseEntity {
    override fun getPk(): Long {
        return id
    }
}