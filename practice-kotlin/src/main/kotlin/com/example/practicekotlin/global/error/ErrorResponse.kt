package com.example.practicekotlin.global.error

import com.example.practicekotlin.global.error.exception.BusinessException

class ErrorResponse (
    val status: Int,
    val message: String
) {

    companion object {
        fun of(e: BusinessException): ErrorResponse {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }

}