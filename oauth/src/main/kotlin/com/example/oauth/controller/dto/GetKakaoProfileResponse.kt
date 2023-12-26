package com.example.oauth.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GetKakaoProfileResponse(
    val id: Long,
    @JsonProperty("kakao_account")
    val kakaoAccount: KakaoAccount

)

data class KakaoAccount(
//    @JsonProperty("profile_needs_agreement")
//    val profileNeedsAgreement: Boolean,
//    @JsonProperty("profile_nickname_needs_agreement")
//    val profileNicknameNeedsAgreement: Boolean,
//    @JsonProperty("profile_image_needs_agreemen")
//    val profileImageNeedsAgreemen: Boolean,
    val profile: Profile,
    @JsonProperty("age_range")
    val ageRange: String?,
    val gender: String,
)

data class Profile(
    val nickname: String,
    @JsonProperty("profile_image_url")
    val profileImageUrl: String,
)
