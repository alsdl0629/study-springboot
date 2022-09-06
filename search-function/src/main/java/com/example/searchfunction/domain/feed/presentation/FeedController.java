package com.example.searchfunction.domain.feed.presentation;

import com.example.searchfunction.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.searchfunction.domain.feed.presentation.dto.response.SearchResponse;
import com.example.searchfunction.domain.feed.service.CreateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void createFeed(@Valid @RequestBody CreateFeedRequest request) {
        createFeedService.execute(request);
    }

}
