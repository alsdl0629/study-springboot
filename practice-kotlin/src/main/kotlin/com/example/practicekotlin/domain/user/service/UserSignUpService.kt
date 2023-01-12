package com.example.practicekotlin.domain.user.service

import com.example.practicekotlin.domain.user.domain.User
import com.example.practicekotlin.domain.user.domain.repository.UserRepository
import com.example.practicekotlin.domain.user.domain.type.Authority
import com.example.practicekotlin.domain.user.exception.AlreadyUserExists
import com.example.practicekotlin.domain.user.presentation.dto.request.UserSignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun execute(request: UserSignUpRequest) {

        if(userRepository.existsByAccountId(request.accountId))  {
            throw AlreadyUserExists.EXCEPTION
        }

        userRepository.save(User(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            authority = Authority.USER
        )
        )

    }

}