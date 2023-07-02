package com.example.socketcommunication.domain.user.facade;

import com.example.socketcommunication.domain.user.domain.User;
import com.example.socketcommunication.domain.user.domain.repository.UserRepository;
import com.example.socketcommunication.domain.user.exception.UserAlreadyExistsException;
import com.example.socketcommunication.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }


    public void isAlreadyExists(String email) {
        if(userRepository.existsByEmail(email)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }
    }

}
