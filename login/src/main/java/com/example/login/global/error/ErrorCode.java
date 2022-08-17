package com.example.login.global.error;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists");


    private final int status;

    private final String message;

}
