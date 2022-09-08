package com.example.login.damain.user.service;

import com.example.login.damain.user.domain.repository.UserRepository;
import com.example.login.damain.user.exception.UserAlreadyExistsException;
import com.example.login.damain.user.facade.AuthCodeFacade;
import com.example.login.damain.user.presentation.dto.request.EmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthCodeService {

    private final UserRepository userRepository;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public void execute(EmailRequest request) {

        String email = request.getEmail();

        if(userRepository.existsByEmail(email)) {
           throw UserAlreadyExistsException.EXCEPTION;
        }

        authCodeFacade.sendEmail(email);
    }

}
