package com.example.practicekotlin.domain.feed.exception

import com.example.practicekotlin.global.error.exception.BusinessException
import com.example.practicekotlin.global.error.exception.GlobalErrorCode

class FeedNotFound private constructor(): BusinessException(GlobalErrorCode.FEED_NOT_FOUND) {
    companion object {
        val EXCEPTION = FeedNotFound()
    }
}