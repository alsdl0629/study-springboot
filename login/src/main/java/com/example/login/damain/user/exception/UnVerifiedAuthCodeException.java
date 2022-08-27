package com.example.login.damain.user.exception;

import com.example.login.global.error.exception.BusinessException;
import com.example.login.global.error.exception.ErrorCode;

public class UnVerifiedAuthCodeException extends BusinessException {

    public static BusinessException EXCEPTION =
            new UnVerifiedAuthCodeException();

    public UnVerifiedAuthCodeException() {
        super(ErrorCode.UNVERIFIED_AUTH_CODE);
    }

}
