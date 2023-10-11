package com.example.openfeign;

import com.example.openfeign.feign_client.HelloOpenFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {

    private final HelloOpenFeign feign;

    @PostMapping("/hello")
    public KakaoResponse hello() {
        KakaoRequest request = KakaoRequest.builder()
                .prompt("cute puppy")
                .build();
        return feign.hello(request);
    }

}
