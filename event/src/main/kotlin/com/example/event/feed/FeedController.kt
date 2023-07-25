package com.example.event.feed

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val feedService: FeedService
) {

    @PostMapping
    fun createFeed(@RequestBody request: CreateFeedRequest) {
        feedService.createFeed(request)
    }

    data class CreateFeedRequest(
        val title: String,
        val content: String
    )
}