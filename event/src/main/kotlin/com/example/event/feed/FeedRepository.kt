package com.example.event.feed

import org.springframework.data.repository.CrudRepository

interface FeedRepository : CrudRepository<Feed, Long>
