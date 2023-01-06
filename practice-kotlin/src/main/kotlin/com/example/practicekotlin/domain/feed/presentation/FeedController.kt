package com.example.practicekotlin.domain.feed.presentation

import com.example.practicekotlin.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.practicekotlin.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.practicekotlin.domain.feed.presentation.dto.response.QueryFeedListResponse
import com.example.practicekotlin.domain.feed.presentation.dto.response.QueryFeedResponse
import com.example.practicekotlin.domain.feed.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val createFeedService: CreateFeedService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val queryFeedDetailService: QueryFeedDetailService,
    private val queryFeedListService: QueryFeedListService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createFeed(@RequestBody request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") feedId: Long,
                   @RequestBody request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") feedId: Long) {
        deleteFeedService.execute(feedId)
    }

    @GetMapping("/{feed-id}")
    fun getFeedDetail(@PathVariable("feed-id") feedId: Long): QueryFeedResponse {
        return queryFeedDetailService.execute(feedId)
    }

    @GetMapping
    fun getFeedList(): QueryFeedListResponse {
        return queryFeedListService.execute()
    }

}