package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.domain.Feed
import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.presentation.dto.response.QueryFeedListResponse
import com.example.practicekotlin.domain.feed.presentation.dto.response.QueryFeedResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedListService (
    private val feedRepository: FeedRepository
) {

    @Transactional(readOnly = true)
    fun execute(): QueryFeedListResponse {

        val feedList = feedRepository.findAll()
            .map {
            QueryFeedResponse(
                feedId = it.id,
                title = it.title,
                content = it.content
            )
        }.toList()

        return QueryFeedListResponse(feedList)
    }

}