package com.example.practicekotlin.domain.user.domain

import com.example.practicekotlin.domain.user.domain.type.Authority
import javax.persistence.*

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    accountId: String,

    password: String,

    authority: Authority
) {

    var accountId = accountId
        protected set

    var password = password
        protected set

    @Enumerated(EnumType.STRING)
    val authority = authority

}