package com.team1.coworkings.entity

import jakarta.persistence.*

@Entity
@Table(name = "role", schema = "coworkings")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "code", unique = true, nullable = false)
    var code: String,
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    private val users: Set<User> = emptySet()
)