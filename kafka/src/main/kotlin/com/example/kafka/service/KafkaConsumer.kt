package com.example.kafka.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer {

    @KafkaListener(topics = ["kafka-demo"], groupId = "kafka-demo")
    fun consume(message: String) {
        println("Consumed message: $message")
    }
}