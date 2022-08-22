package com.example.login.damain.user.exception;

import com.example.login.global.error.exception.BusinessException;
import com.example.login.global.error.exception.ErrorCode;

public class InvalidPasswordException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }

}
