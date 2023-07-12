package com.example.imageupload.domain.image.service;

import com.example.imageupload.domain.image.presentation.PreSignedUrlResponse;
import com.example.imageupload.infrastructure.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetPreSignedUrlService {

    private final S3Service s3Service;

    public PreSignedUrlResponse execute(String imageUrl) {
        String preSignedUrl = s3Service.getPreSignedUrl(imageUrl);

        return new PreSignedUrlResponse(preSignedUrl, imageUrl);
    }
}
