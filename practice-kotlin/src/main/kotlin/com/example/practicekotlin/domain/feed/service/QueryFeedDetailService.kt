package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.facade.FeedFacade
import com.example.practicekotlin.domain.feed.presentation.dto.response.QueryFeedResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedDetailService(
    private val feedFacade: FeedFacade
) {

    @Transactional(readOnly = true)
    fun execute(feedId: Long): QueryFeedResponse {

        val feed = feedFacade.getFeedById(feedId)

        return QueryFeedResponse(
            feedId = feed.id,
            title = feed.title,
            content = feed.content
        )
    }

}