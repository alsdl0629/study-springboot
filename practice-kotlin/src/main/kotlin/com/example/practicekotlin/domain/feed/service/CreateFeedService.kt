package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.domain.Feed
import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository
) {

    @Transactional
    fun execute(request: CreateFeedRequest) {

        feedRepository.save(
            Feed(
                request.title,
                request.content
            ))
    }

}