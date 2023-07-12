package com.example.imageupload.domain.image.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PreSignedUrlResponse {

    private final String preSignedUrl;

    private final String imageUrl;
}
