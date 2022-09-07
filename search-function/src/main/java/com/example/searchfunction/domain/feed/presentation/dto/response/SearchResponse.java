package com.example.searchfunction.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SearchResponse {

    private final Integer feedId;

    private final String title;

    private final String content;

}
