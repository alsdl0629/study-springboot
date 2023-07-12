package com.example.imageupload.domain.image.presentation;

import com.example.imageupload.domain.image.service.GetPreSignedUrlService;
import com.example.imageupload.domain.image.service.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@RequestMapping("/images")
@RestController
public class ImageController {

    private final UploadImageService uploadImageService;
    private final GetPreSignedUrlService getPreSignedUrlService;

    @PostMapping
    public ImageUrlResponse uploadImage(@RequestPart @NotNull MultipartFile image) {
        return uploadImageService.execute(image);
    }

    @GetMapping("/pre-signed-url")
    public PreSignedUrlResponse getPreSignedUrl(@RequestParam(name = "image") String image) {
        return getPreSignedUrlService.execute(image);
    }
}
