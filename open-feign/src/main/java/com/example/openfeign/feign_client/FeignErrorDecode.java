package com.example.openfeign.feign_client;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import static java.lang.String.format;

@Slf4j
public class FeignErrorDecode implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        log.error(format("%s 요청이 성공하지 못했습니다. status: %s requestUrl: %s, requestBody: %s, responseBody: %s",
                methodKey, response.status(), response.request().url(), Arrays.toString(response.request().body()), response.body()));
        if (isRetry(response)) {
            return new RetryableException(response.status(), format("%s 요청이 성공하지 못했습니다. Retry 합니다. - status: %s, headers: %s", methodKey, response.status(), response.headers()),
                    response.request().httpMethod(), Date.from(Instant.now()), response.request());
        }

        return new IllegalStateException(format("%s 요청이 성공하지 못했습니다. - cause: %s, headers: %s", methodKey, response.status(), response.headers()));
    }

    private boolean isRetry(Response response) {
        return response.request()
                .httpMethod()
                .name()
                .equalsIgnoreCase("POST");
    }
}
