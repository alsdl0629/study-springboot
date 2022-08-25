package com.example.login.damain.user.presentation;

import com.example.login.damain.user.presentation.dto.request.LoginRequest;
import com.example.login.damain.user.presentation.dto.request.SignupRequest;
import com.example.login.damain.user.presentation.dto.response.TokenResponse;
import com.example.login.damain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void Signup(@RequestBody @Valid SignupRequest request) {
        userService.signup(request);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }

}
