package com.example.login.damain.user.exception;

import com.example.login.global.error.exception.BusinessException;
import com.example.login.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }

}
