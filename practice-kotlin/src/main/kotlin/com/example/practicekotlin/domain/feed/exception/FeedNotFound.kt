package com.example.practicekotlin.domain.feed.exception

import com.example.practicekotlin.global.error.exception.BusinessException
import com.example.practicekotlin.global.error.exception.ErrorCode

class FeedNotFound private constructor(): BusinessException(ErrorCode.FEED_NOT_FOUND) {
    companion object {
        val EXCEPTION = FeedNotFound()
    }
}