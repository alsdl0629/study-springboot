package com.example.practicekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class PracticeKotlinApplication

fun main(args: Array<String>) {
    runApplication<PracticeKotlinApplication>(*args)
}
