package com.example.login.damain.refreshtoken;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class RefreshToken {

    @Id
    private String userEmail;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private Long ttl;

    @Builder
    public RefreshToken(String userEmail, String refreshToken, Long ttl) {
        this.userEmail = userEmail;
        this.refreshToken = refreshToken;
        this.ttl = ttl;
    }

}
