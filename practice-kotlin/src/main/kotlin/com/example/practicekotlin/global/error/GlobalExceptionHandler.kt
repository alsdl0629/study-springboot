package com.example.practicekotlin.global.error

import com.example.practicekotlin.global.error.exception.BusinessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun businessExceptionHandler(e: BusinessException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse.of(e),
            HttpStatus.valueOf(e.status)
        )
    }

}