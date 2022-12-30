package com.example.practicekotlin.domain.feed.domain.repository

import com.example.practicekotlin.domain.feed.domain.Feed
import org.springframework.data.repository.CrudRepository

interface FeedRepository: CrudRepository<Feed, Long> {
}