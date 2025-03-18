package com.team1.coworkings.entity

import jakarta.persistence.*

@Entity
@Table(name = "user", schema = "coworkings")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Long = 0,
    @Column(name = "login", unique = true, nullable = false)
    var login: String,
    @Column(name = "name", nullable = false)
    var name: String,
    @Column(name = "email", unique = true, nullable = false)
    var email: String,
    @Column(name = "password", nullable = false)
    var password: String = "",
    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id")
    var role: Role
)
