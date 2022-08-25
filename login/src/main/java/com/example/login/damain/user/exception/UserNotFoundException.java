package com.example.login.damain.user.exception;

import com.example.login.global.error.exception.BusinessException;
import com.example.login.global.error.exception.ErrorCode;

public class UserNotFoundException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
