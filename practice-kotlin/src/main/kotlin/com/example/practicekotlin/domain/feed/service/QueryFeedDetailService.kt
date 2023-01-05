package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.exception.FeedNotFound
import com.example.practicekotlin.domain.feed.presentation.dto.response.QueryFeedResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedDetailService(
    private val feedRepository: FeedRepository
) {

    @Transactional(readOnly = true)
    fun execute(feedId: Long): QueryFeedResponse {

        val feed = feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFound.EXCEPTION

        return QueryFeedResponse(
            feedId = feed.id,
            title = feed.title,
            content = feed.content
        )
    }

}