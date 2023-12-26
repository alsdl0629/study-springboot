package com.example.oauth.controller.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy::class)
data class TokenResponse(
    val tokenType: String,
    val accessToken: String,
    val expiresIn: Int,
    val refreshToken: String,
    val refreshTokenExpiresIn: Int,
    val scope: String,
)
