package com.example.practicekotlin.domain.feed.exception

import com.example.practicekotlin.global.error.exception.BusinessException
import com.example.practicekotlin.global.error.exception.GlobalErrorCode

class FeedNotFoundException private constructor(): BusinessException(GlobalErrorCode.FEED_NOT_FOUND) {
    companion object {
        val EXCEPTION = FeedNotFoundException()
    }
}