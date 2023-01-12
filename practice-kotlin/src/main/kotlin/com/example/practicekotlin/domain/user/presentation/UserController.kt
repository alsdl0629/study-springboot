package com.example.practicekotlin.domain.user.presentation

import com.example.practicekotlin.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.practicekotlin.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun userSignUp(@RequestBody request: UserSignUpRequest) {
        userSignUpService.execute(request)
    }

}