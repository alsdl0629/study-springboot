package com.example.login.damain.auth.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class AuthCode implements Serializable {

    @Id @Indexed
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

}
