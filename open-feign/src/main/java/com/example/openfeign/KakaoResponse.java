package com.example.openfeign;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class KakaoResponse {

    private String id;
    private String modelVersion;
    private List<ImageResponse> images;

    @Getter
    @Builder
    public static class ImageResponse {
        private String id;
        private int seed;
        private String image;
        private Boolean nsfwContentDetected;
        private Double nsfwScore;
    }
}
