package com.example.login.damain.user.service;

import com.example.login.damain.user.entity.Authority;
import com.example.login.damain.user.entity.User;
import com.example.login.damain.user.entity.repository.UserRepository;
import com.example.login.damain.user.exception.UnVerifiedAuthCodeException;
import com.example.login.damain.user.facade.AuthCodeFacade;
import com.example.login.damain.user.facade.UserFacade;
import com.example.login.damain.user.presentation.dto.request.SignupRequest;
import com.example.login.damain.user.presentation.dto.response.TokenResponse;
import com.example.login.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;
    private final AuthCodeFacade authCodeFacade;

    @Transactional
    public TokenResponse execute(SignupRequest request) {

        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());
        String name = request.getName();

        userFacade.isAlreadyExists(email);

        if(!authCodeFacade.isVerify(email)) {
            throw UnVerifiedAuthCodeException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .email(email)
                .password(password)
                .name(name)
                .authority(Authority.ROLE_USER)
                .build());

        return jwtTokenProvider.generateToken(email);
    }

}
