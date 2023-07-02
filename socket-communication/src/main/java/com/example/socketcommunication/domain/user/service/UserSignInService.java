package com.example.socketcommunication.domain.user.service;

import com.example.socketcommunication.domain.user.domain.User;
import com.example.socketcommunication.domain.user.domain.repository.UserRepository;
import com.example.socketcommunication.domain.user.exception.InvalidPasswordException;
import com.example.socketcommunication.domain.user.exception.UserNotFoundException;
import com.example.socketcommunication.domain.user.presentation.dto.request.LoginRequest;
import com.example.socketcommunication.domain.user.presentation.dto.response.TokenResponse;
import com.example.socketcommunication.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(LoginRequest request) {

        String email = request.getEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(email);

        return new TokenResponse(accessToken);
    }

}
