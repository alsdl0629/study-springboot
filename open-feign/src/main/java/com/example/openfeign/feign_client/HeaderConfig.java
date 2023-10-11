package com.example.openfeign.feign_client;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "KakaoAK 545d5397fb98ca69c945f067a84fcb47");
            requestTemplate.header("Content-Type", "application/json");
        };
    }
}
