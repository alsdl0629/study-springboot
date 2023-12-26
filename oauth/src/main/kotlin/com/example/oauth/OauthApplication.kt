package com.example.oauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@ConfigurationPropertiesScan
@EnableFeignClients
@SpringBootApplication
class OauthApplication

fun main(args: Array<String>) {
	runApplication<OauthApplication>(*args)
}
