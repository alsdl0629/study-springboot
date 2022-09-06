package com.example.searchfunction.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotNull(message = "title은 Null을 허용하지 않습니다.")
    private String title;

    @NotNull(message = "content는 Null을 허용하지 않습니다.")
    private String content;

}
