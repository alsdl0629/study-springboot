package com.example.practicekotlin.domain.feed.presentation

import com.example.practicekotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.practicekotlin.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.practicekotlin.domain.feed.service.CreateFeedService
import com.example.practicekotlin.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val updateFeedService: UpdateFeedService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") feedId: Long,
                   @RequestBody request: UpdateFeedRequest
    ) {
        updateFeedService.execute(feedId, request)
    }

}