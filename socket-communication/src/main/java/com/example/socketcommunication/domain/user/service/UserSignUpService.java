package com.example.socketcommunication.domain.user.service;

import com.example.socketcommunication.domain.user.domain.Authority;
import com.example.socketcommunication.domain.user.domain.User;
import com.example.socketcommunication.domain.user.domain.repository.UserRepository;
import com.example.socketcommunication.domain.user.facade.UserFacade;
import com.example.socketcommunication.domain.user.presentation.dto.request.SignupRequest;
import com.example.socketcommunication.domain.user.presentation.dto.response.TokenResponse;
import com.example.socketcommunication.global.security.jwt.JwtTokenProvider;

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

    @Transactional
    public TokenResponse execute(SignupRequest request) {

        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());

        userFacade.isAlreadyExists(email);

        userRepository.save(User.builder()
                .email(email)
                .password(password)
                .authority(Authority.ROLE_USER)
                .build());

        String accessToken = jwtTokenProvider.generateAccessToken(email);

        return new TokenResponse(accessToken);
    }

}
