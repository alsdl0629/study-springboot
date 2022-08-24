package com.example.login.damain.user.exception;

import com.example.login.global.error.exception.BusinessException;
import com.example.login.global.error.exception.ErrorCode;

public class UserAlreadyException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UserAlreadyException();

    private UserAlreadyException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }

}
