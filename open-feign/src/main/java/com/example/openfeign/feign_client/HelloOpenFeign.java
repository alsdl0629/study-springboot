package com.example.openfeign.feign_client;

import com.example.openfeign.KakaoRequest;
import com.example.openfeign.KakaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "karlo", url = "https://api.kakaobrain.com/v2", configuration = {HeaderConfig.class})
public interface HelloOpenFeign {

    @PostMapping("/inference/karlo/t2i")
    KakaoResponse hello(KakaoRequest request);
}
