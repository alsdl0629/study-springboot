package com.example.login.damain.user.service;

import com.example.login.damain.user.facade.AuthCodeFacade;
import com.example.login.damain.user.facade.UserFacade;
import com.example.login.damain.user.presentation.dto.request.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthCodeService {
    
    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(EmailRequest request) {

        String email = request.getEmail();

        userFacade.isAlreadyExists(request.getEmail());

        authCodeFacade.sendEmail(email);
    }

}
