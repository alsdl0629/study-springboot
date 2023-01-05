package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.facade.FeedFacade
import com.example.practicekotlin.domain.feed.presentation.dto.request.UpdateFeedRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateFeedService(
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(feedId: Long, request: UpdateFeedRequest) {

        val feed = feedFacade.getFeedById(feedId)

        feed.updateFeed(
            title = request.title,
            content = request.content
        )
    }

}