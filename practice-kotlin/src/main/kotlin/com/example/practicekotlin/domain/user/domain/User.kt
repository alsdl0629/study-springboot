package com.example.practicekotlin.domain.user.domain

import com.example.practicekotlin.domain.user.domain.type.Authority
import javax.persistence.*

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val accountId: String,

    var password: String,

    @Enumerated(EnumType.STRING)
    val authority: Authority
)