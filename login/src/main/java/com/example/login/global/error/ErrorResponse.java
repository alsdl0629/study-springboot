package com.example.login.global.error;

import lombok.*;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private final int status;

    private final String message;
    
}
