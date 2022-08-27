package com.example.login.global.error.exception;

import lombok.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(401, "Invalid Token"),
    EXPIRED_TOKEN(401, "Expired Token"),
    INVALID_PASSWORD(401, "Invalid Password"),
    INVALID_AUTH_CODE(401, "Invalid Auth Code"),
    UNVERIFIED_AUTH_CODE(401, "UnVerified Auth Code"),

    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists")
    ;


    private final int status;

    private final String message;

}
