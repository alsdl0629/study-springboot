package com.example.login.damain.user.service;

import com.example.login.damain.user.entity.User;
import com.example.login.damain.user.entity.repository.UserRepository;
import com.example.login.damain.user.exception.InvalidPasswordException;
import com.example.login.damain.user.exception.UserNotFoundException;
import com.example.login.damain.user.presentation.dto.request.LoginRequest;
import com.example.login.damain.user.presentation.dto.response.TokenResponse;
import com.example.login.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;


    public TokenResponse execute(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        return jwtTokenProvider.generateToken(user.getEmail());
    }

}
