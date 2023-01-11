package com.example.practicekotlin.domain.user.domain.repository

import com.example.practicekotlin.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {

    fun findByAccountId(accountId: String): User?

    fun existsByAccountId(accountId: String): Boolean

}