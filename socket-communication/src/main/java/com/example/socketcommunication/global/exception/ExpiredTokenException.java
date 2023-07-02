package com.example.socketcommunication.global.exception;

import com.example.socketcommunication.global.error.exception.BusinessException;
import com.example.socketcommunication.global.error.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {

    public static BusinessException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }

}
