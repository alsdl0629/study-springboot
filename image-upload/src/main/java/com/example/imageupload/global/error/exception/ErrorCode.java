package com.example.imageupload.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_ALREADY_EXISTS(404, "User Already Exists")
    ;

    private final int status;

    private final String message;

}
