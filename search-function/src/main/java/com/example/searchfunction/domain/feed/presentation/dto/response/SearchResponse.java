package com.example.searchfunction.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class SearchResponse {

    private final Integer feedId;

    private final String title;

    private final String content;

    private final LocalDateTime createdAt;

}
