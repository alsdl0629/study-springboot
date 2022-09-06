package com.example.searchfunction.domain.feed.domain.repository;

import com.example.searchfunction.domain.feed.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
