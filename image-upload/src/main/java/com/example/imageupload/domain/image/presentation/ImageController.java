package com.example.imageupload.domain.image.presentation;

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

    @PostMapping
    public ImageUrlResponse uploadImage(@RequestPart @NotNull MultipartFile image) {
        return uploadImageService.execute(image);
    }
}
