package com.example.practicekotlin.domain.feed.facade

import com.example.practicekotlin.domain.feed.domain.Feed
import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.exception.FeedNotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedFacade(
    private val feedRepository: FeedRepository
) {

    fun getFeedById(feedId: Long): Feed {
        return feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFound.EXCEPTION
    }

}