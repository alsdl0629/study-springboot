package com.example.login.damain.user.service;

import com.example.login.damain.user.entity.repository.UserRepository;
import com.example.login.damain.user.exception.UserAlreadyExistsException;
import com.example.login.damain.user.facade.AuthCodeFacade;
import com.example.login.damain.user.presentation.dto.request.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final UserRepository userRepository;
    private final AuthCodeFacade authCodeFacade;

    public void execute(EmailRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
           throw UserAlreadyExistsException.EXCEPTION;
        }

        authCodeFacade.sendEmail(request.getEmail());
    }

}
