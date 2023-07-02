package com.example.socketcommunication.global.exception;

import com.example.socketcommunication.global.error.exception.BusinessException;
import com.example.socketcommunication.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}
