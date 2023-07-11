package com.example.imageupload.domain.image.service;

import com.example.imageupload.domain.image.presentation.ImageUrlResponse;
import com.example.imageupload.infrastructure.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadImageService {

    private final S3Service service;

    public ImageUrlResponse execute(MultipartFile multipartFile) {
        String fileName = service.uploadImage(multipartFile);

        return new ImageUrlResponse(fileName);
    }
}
