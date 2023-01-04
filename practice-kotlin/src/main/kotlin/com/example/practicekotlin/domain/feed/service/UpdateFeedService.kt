package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.exception.FeedNotFound
import com.example.practicekotlin.domain.feed.presentation.dto.request.UpdateFeedRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateFeedService(
    private val feedRepository: FeedRepository
) {

    @Transactional
    fun execute(feedId: Long, request: UpdateFeedRequest) {

        val feed = feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFound.EXCEPTION

        feed.updateFeed(
            title = request.title,
            content = request.content
        )
    }

}