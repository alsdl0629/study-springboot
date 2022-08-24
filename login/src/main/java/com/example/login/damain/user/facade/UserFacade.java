package com.example.login.damain.user.facade;

import com.example.login.damain.user.entity.repository.UserRepository;
import com.example.login.damain.user.exception.UserAlreadyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public void isAlreadyExists(String email) {
        if(userRepository.existsByEmail(email)) {
            throw UserAlreadyException.EXCEPTION;
        }
    }

}
