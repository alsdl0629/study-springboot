package com.example.practicekotlin.domain.user.presentation.dto.request

data class UserSignUpRequest(
    val accountId: String,
    val password: String
)