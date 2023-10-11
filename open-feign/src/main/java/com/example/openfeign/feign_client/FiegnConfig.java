package com.example.openfeign.feign_client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiegnConfig {

    @Bean
    public ErrorDecoder decoder() {
        return new FeignErrorDecode();
    }
}
