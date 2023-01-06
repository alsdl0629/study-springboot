package com.example.practicekotlin.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {

    FEED_NOT_FOUND(404, "Feed Not Found");

}