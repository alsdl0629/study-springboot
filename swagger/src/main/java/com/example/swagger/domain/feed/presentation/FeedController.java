package com.example.swagger.domain.feed.presentation;

import com.example.swagger.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.example.swagger.domain.feed.service.CreateFeedService;
import com.example.swagger.domain.feed.service.DeleteFeedService;
import com.example.swagger.domain.feed.service.UpdateFeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "게시글", description = "게시글 관련 API 입니다.")
@RequiredArgsConstructor
@RequestMapping("/feeds")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "게시글 생성하기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "게시글 생성 성공",
                    content = @Content(schema = @Schema(hidden = true)))
    })
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    @Operation(summary = "게시글 수정하기")
    @ApiResponse(responseCode = "204", description = "게시글 수정 성공",
            content = @Content(schema = @Schema(hidden = true)))
    public void updateFeed(@Parameter(description = "게시글 id") @PathVariable(name = "feed-id") Integer feedId,
            @RequestBody @Valid CreateFeedRequest request) {
        updateFeedService.execute(feedId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    @Operation(summary = "게시글 삭제하기")
    @ApiResponse(responseCode = "204", description = "게시글 삭제 성공",
            content = @Content(schema = @Schema(hidden = true)))
    public void deleteFeed(@Parameter(description = "게시글 id") @PathVariable(name = "feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

}
