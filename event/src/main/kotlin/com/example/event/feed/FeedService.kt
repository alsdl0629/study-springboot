package com.example.event.feed

import com.example.event.EntityCreated
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val feedRepository: FeedRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun createFeed(request: FeedController.CreateFeedRequest) {
        val feed = feedRepository.save(
            Feed(title = request.title, content = "content")
        )
        applicationEventPublisher.publishEvent(
            EntityCreated(feed.id)
        )
    }
}