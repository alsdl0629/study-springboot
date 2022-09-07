package com.example.searchfunction.domain.feed.service;

import com.example.searchfunction.domain.feed.domain.repository.FeedRepository;
import com.example.searchfunction.domain.feed.presentation.dto.response.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchFeedService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public List<SearchResponse> execute(String keyword) {

        return feedRepository.findByTitleContaining(keyword)
                .stream().map(feed -> {
                    return SearchResponse.builder()
                            .feedId(feed.getId())
                            .title(feed.getTitle())
                            .content(feed.getContent())
                            .build();
                })
                .collect(Collectors.toList());
    }

}
