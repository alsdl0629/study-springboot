package com.example.login.damain.user.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class AuthCode {

    @Id
    private String email;

    private String code;

    private boolean isVerify;

    @TimeToLive
    private Long ttl;

    @Builder
    public AuthCode(String email, String code) {
        this.email = email;
        this.code = code;
        this.isVerify = false;
        this.ttl = 300L;
    }

    public void changeVerify() {
        this.isVerify = true;
    }

}
