package com.example.swagger.domain.feed.service;

import com.example.swagger.domain.feed.domain.Feed;
import com.example.swagger.domain.feed.domain.repository.FeedRepository;
import com.example.swagger.domain.feed.presentation.dto.request.CreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(CreateFeedRequest request) {

        feedRepository.save(Feed
                        .builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }

}
