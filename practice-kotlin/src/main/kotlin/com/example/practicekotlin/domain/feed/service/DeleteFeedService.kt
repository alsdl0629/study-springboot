package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.exception.FeedNotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteFeedService(
    private val feedRepository: FeedRepository
) {

    @Transactional
    fun execute(feedId: Long) {

        val feed = feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFound.EXCEPTION

        feedRepository.delete(feed)
    }

}