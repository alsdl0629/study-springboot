package com.example.sms.domain.presentation

import com.example.sms.infrastructure.sms.CoolSmsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/send")
@RestController
class SmsController(
    private val coolSmsService: CoolSmsService
) {

    @PostMapping
    fun sendMessage(@RequestBody request: SendMessageRequest) {
        coolSmsService.sendMessage(request.to)
    }
}
