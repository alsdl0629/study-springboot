package com.example.practicekotlin.domain.feed.presentation.dto.response

data class QueryFeedResponse (
    val feedId: Long,
    val title: String,
    val content: String
)