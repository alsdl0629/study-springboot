package com.example.oauth.client

import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level? {
        return Logger.Level.FULL
    }
}