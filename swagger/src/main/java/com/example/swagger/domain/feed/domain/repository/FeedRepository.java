package com.example.swagger.domain.feed.domain.repository;

import com.example.swagger.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, Integer> {
}
