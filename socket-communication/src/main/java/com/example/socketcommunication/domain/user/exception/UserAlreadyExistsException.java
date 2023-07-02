package com.example.socketcommunication.domain.user.exception;

import com.example.socketcommunication.global.error.exception.BusinessException;
import com.example.socketcommunication.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }

}
