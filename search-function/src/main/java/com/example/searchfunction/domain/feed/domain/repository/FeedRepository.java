package com.example.searchfunction.domain.feed.domain.repository;

import com.example.searchfunction.domain.feed.domain.Feed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Integer> {
    Page<Feed> findByTitleContaining(String keyword, Pageable pageable);
}
