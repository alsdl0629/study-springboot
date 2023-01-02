package com.example.swagger.domain.feed.service;

import com.example.swagger.domain.feed.domain.Feed;
import com.example.swagger.domain.feed.domain.repository.FeedRepository;
import com.example.swagger.domain.feed.presentation.dto.request.CreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(Integer feedId, CreateFeedRequest request) {

        Feed feed = feedRepository.findById(feedId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾지 못함"));

        feed.updateFeed(request.getTitle(), request.getContent());
    }

}
