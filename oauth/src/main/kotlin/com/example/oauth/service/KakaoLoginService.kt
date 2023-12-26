package com.example.oauth.service

import com.example.oauth.client.KakaoAuthClient
import com.example.oauth.client.KakaoAuthProperties.CLIENT_ID
import com.example.oauth.client.KakaoAuthProperties.GRANT_TYPE
import com.example.oauth.client.KakaoAuthProperties.REDIRECT_URL
import com.example.oauth.client.KakaoAuthProperties.SECRET_KEY
import com.example.oauth.client.KakaoProfileClient
import com.example.oauth.controller.dto.GetKakaoProfileResponse
import com.example.oauth.controller.dto.TokenResponse
import org.springframework.stereotype.Service

@Service
class KakaoLoginService(
    private val kakaoAuthClient: KakaoAuthClient,
    private val kakaoProfileClient: KakaoProfileClient,
) {
    fun login(code: String): TokenResponse {
        return kakaoAuthClient.IssueToken(
            grantType = GRANT_TYPE,
            clientId = CLIENT_ID,
            redirectUrl = REDIRECT_URL,
            code = code,
            clientSecret = SECRET_KEY
        )
    }

    fun getKakaoProfile(token: String): GetKakaoProfileResponse {
        return kakaoProfileClient.getProfile(
            authorization = token,
            contentType = "application/json",
        )
    }
}
