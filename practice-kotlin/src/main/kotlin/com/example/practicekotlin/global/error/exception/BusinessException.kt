package com.example.practicekotlin.global.error.exception

import java.lang.RuntimeException

abstract class BusinessException (
    val errorCode: ErrorCode
): RuntimeException() {

    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message

}