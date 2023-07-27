package com.example.kafka.controller

import com.example.kafka.service.KafkaProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/kafka")
@RestController
class KafkaController(
    private val kafkaProducer: KafkaProducer
) {

    @PostMapping
    fun sendMessage(@RequestParam message: String) {
        kafkaProducer.sendMessage(message)
    }
}