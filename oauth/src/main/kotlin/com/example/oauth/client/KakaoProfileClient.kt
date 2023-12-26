package com.example.oauth.client

import com.example.oauth.controller.dto.GetKakaoProfileResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "kakao-profile", url = "https://kapi.kakao.com", configuration = [ClientConfig::class])
interface KakaoProfileClient {

    @GetMapping("/v2/user/me")
    fun getProfile(
        @RequestHeader(name = "Authorization") authorization: String,
        @RequestHeader(name = "Content-type") contentType: String,
    ) : GetKakaoProfileResponse
}
