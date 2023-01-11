package com.example.practicekotlin.global.security.auth

import com.example.practicekotlin.domain.user.domain.repository.UserRepository
import com.example.practicekotlin.domain.user.exception.UserNotFound
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByAccountId(username) ?: throw UserNotFound.EXCEPTION
        return AuthDetails(user)
    }

}