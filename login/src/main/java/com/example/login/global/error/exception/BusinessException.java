package com.example.login.global.error.exception;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

}
