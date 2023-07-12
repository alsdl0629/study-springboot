package com.example.sms.infrastructure.sms

import net.nurigo.java_sdk.api.Message
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class CoolSmsService(
    @Value("\${cool-sms.api-key}")
    private val apiKey: String,
    @Value("\${cool-sms.secret-key}")
    private val secretKey: String,
    @Value("\${cool-sms.from}")
    private val from: String
) {

    fun sendMessage(to: String) {
        val message = Message(apiKey, secretKey)

        val params = HashMap<String, String>()
        params["to"] = to
        params["from"] = from
        params["type"] = "sms"
        params["text"] = "sms 테스트"

        message.send(params)
    }
}
