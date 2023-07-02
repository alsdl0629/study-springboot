package com.example.socketcommunication.domain.user.exception;

import com.example.socketcommunication.global.error.exception.BusinessException;
import com.example.socketcommunication.global.error.exception.ErrorCode;

public class InvalidPasswordException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidPasswordException();

    private InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }

}
