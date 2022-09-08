package com.example.searchfunction.domain.feed.presentation;

import com.example.searchfunction.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.searchfunction.domain.feed.presentation.dto.response.SearchResponse;
import com.example.searchfunction.domain.feed.service.CreateFeedService;
import com.example.searchfunction.domain.feed.service.SearchFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final SearchFeedService searchFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@Valid @RequestBody CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @GetMapping("/search")
    public List<SearchResponse> searchFeed(@RequestParam String keyword,
                                           @PageableDefault(sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return searchFeedService.execute(keyword, pageable);
    }

}
