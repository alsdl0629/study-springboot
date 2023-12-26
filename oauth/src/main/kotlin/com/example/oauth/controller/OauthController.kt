package com.example.oauth.controller

import com.example.oauth.client.KakaoAuthProperties.CLIENT_ID
import com.example.oauth.client.KakaoAuthProperties.REDIRECT_URL
import com.example.oauth.client.KakaoAuthProperties.RESPONSE_TYPE
import com.example.oauth.controller.dto.GetKakaoProfileResponse
import com.example.oauth.controller.dto.TokenResponse
import com.example.oauth.service.KakaoLoginService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class OauthController(
    private val kakaoLoginService: KakaoLoginService,
) {

    @GetMapping("/oauth2/kakao/page")
    fun getKakaoLoginPage() =
        "redirect:https://kauth.kakao.com/oauth/authorize?client_id=$CLIENT_ID&redirect_uri=$REDIRECT_URL&response_type=${RESPONSE_TYPE}"

    @ResponseBody
    @GetMapping("/oauth2/kakao")
    fun kakaoLogin(@RequestParam("code") code: String): TokenResponse {
        return kakaoLoginService.login(code)
    }

    @ResponseBody
    @GetMapping("/oauth2/kakao/me")
    fun getKakaoProfile(
        @RequestHeader("Authorization") token: String,
    ): GetKakaoProfileResponse {
        return kakaoLoginService.getKakaoProfile(token)
    }
}