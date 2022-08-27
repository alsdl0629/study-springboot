package com.example.login.damain.user.service;

import com.example.login.damain.user.domain.AuthCode;
import com.example.login.damain.user.domain.repository.AuthCodeRepository;
import com.example.login.damain.user.exception.InvalidAuthCodeException;
import com.example.login.damain.user.facade.AuthCodeFacade;
import com.example.login.damain.user.presentation.dto.request.VerifyAuthCodeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VerifyAuthCodeService {

    private final AuthCodeRepository authCodeRepository;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(VerifyAuthCodeRequest request) {

        AuthCode authCode = authCodeFacade.getAuthCodeById(request.getEmail());

        if(authCode.isVerify() || !authCode.getCode().equals(request.getCode())) {
            throw InvalidAuthCodeException.EXCEPTION;
        }

        authCode.changeVerify();
    }

}
