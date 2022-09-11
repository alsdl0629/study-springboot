package com.example.imageupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ImageUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageUploadApplication.class, args);
    }

}
