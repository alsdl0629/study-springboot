package com.example.event.feed

import com.example.event.EntityCreated
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class FeedService(
    private val feedRepository: FeedRepository,
    private val applicationContext: ApplicationContext
) {

    fun createFeed(request: FeedController.CreateFeedRequest) {
        val feed = feedRepository.save(
            Feed(title = request.title, content = "content")
        )
        applicationContext.publishEvent(EntityCreated(
            feed, feed.id
        ))
    }
}