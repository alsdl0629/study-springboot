package com.example.oauth.client

import com.example.oauth.controller.dto.TokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "kakao-auth", url = "https://kauth.kakao.com", configuration = [ClientConfig::class])
interface KakaoAuthClient {

    @PostMapping("/oauth/token")
    fun IssueToken(
        @RequestParam("grant_type") grantType: String,
        @RequestParam("client_id") clientId: String,
        @RequestParam("redirect_uri") redirectUrl: String,
        @RequestParam("code") code: String,
        @RequestParam("client_secret") clientSecret: String,
    ): TokenResponse
}
