package com.example.practicekotlin.domain.feed.service

import com.example.practicekotlin.domain.feed.domain.repository.FeedRepository
import com.example.practicekotlin.domain.feed.facade.FeedFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteFeedService(
    private val feedRepository: FeedRepository,
    private val feedFacade: FeedFacade
) {

    @Transactional
    fun execute(feedId: Long) {

        val feed = feedFacade.getFeedById(feedId)

        feedRepository.delete(feed)
    }

}