package com.example.login.global.exception;

import com.example.login.global.error.exception.BusinessException;
import com.example.login.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}
