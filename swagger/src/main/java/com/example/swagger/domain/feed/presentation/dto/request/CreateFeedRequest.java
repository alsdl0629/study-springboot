package com.example.swagger.domain.feed.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotBlank
    private String title;

    @NotNull
    private String content;

}
