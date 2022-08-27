package com.example.login.damain.user.service;

import com.example.login.damain.user.domain.User;
import com.example.login.damain.user.domain.repository.UserRepository;
import com.example.login.damain.user.exception.InvalidPasswordException;
import com.example.login.damain.user.exception.UserNotFoundException;
import com.example.login.damain.user.presentation.dto.request.LoginRequest;
import com.example.login.damain.user.presentation.dto.response.TokenResponse;
import com.example.login.global.security.jwt.JwtTokenProvider;
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
        String refreshToken = jwtTokenProvider.generateRefreshToken(email);

        return new TokenResponse(accessToken, refreshToken);
    }

}
