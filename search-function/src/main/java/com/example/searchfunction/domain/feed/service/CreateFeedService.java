package com.example.searchfunction.domain.feed.service;

import com.example.searchfunction.domain.feed.domain.Feed;
import com.example.searchfunction.domain.feed.domain.repository.FeedRepository;
import com.example.searchfunction.domain.feed.presentation.dto.request.CreateFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;

    @Transactional
    public void execute(CreateFeedRequest request) {

        String title = request.getTitle();
        String content = request.getContent();

        feedRepository.save(Feed.builder()
                .title(title)
                .content(content)
                .build());
    }

}
