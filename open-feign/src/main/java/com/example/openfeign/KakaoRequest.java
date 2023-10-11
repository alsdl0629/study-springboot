package com.example.openfeign;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KakaoRequest {

    private String prompt;
//    private String negativePrompt;
//    private Integer width;
//    private Integer height;
//    private Boolean upscale;
//    private Integer scale;
//    private String imageFormat;
//    private Integer imageQuality;
//    private Integer samples;
//    private String returnType;
//    private Integer priorNumInferenceSteps;
//    private Double priorGuidanceScale;
//    private Integer numInferenceSteps;
//    private Double guidanceScale;
//    private String scheduler;
//    private Integer[] seed;
//    private Boolean nsfwChecker;
}
