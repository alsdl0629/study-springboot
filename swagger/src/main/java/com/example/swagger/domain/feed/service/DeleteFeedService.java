package com.example.swagger.domain.feed.service;

import com.example.swagger.domain.feed.domain.Feed;
import com.example.swagger.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Integer feedId) {

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new RuntimeException("게시글 찾지 못함"));

        feedRepository.delete(feed);
    }

}
