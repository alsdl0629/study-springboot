package com.example.login.damain.user.service;

import com.example.login.damain.user.entity.Authority;
import com.example.login.damain.user.entity.User;
import com.example.login.damain.user.entity.repository.UserRepository;
import com.example.login.damain.user.facade.UserFacade;
import com.example.login.damain.user.presentation.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserFacade userFacade;

    @Transactional
    public void execute(SignupRequest request) {

        userFacade.isAlreadyExists(request.getEmail());

        userRepository.save(User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .authority(Authority.ROLE_USER)
                .build());
    }

}
