package com.example.kafka.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${spring.consumer.group-id}")
    val topic: String
) {

    fun sendMessage(message: String) {
        println(message)
        kafkaTemplate.send(topic, message);
    }
}
