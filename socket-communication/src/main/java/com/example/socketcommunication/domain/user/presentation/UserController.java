package com.example.socketcommunication.domain.user.presentation;

import com.example.socketcommunication.domain.user.presentation.dto.request.LoginRequest;
import com.example.socketcommunication.domain.user.presentation.dto.request.SignupRequest;
import com.example.socketcommunication.domain.user.presentation.dto.response.TokenResponse;
import com.example.socketcommunication.domain.user.service.UserSignInService;
import com.example.socketcommunication.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TokenResponse Signup(@RequestBody SignupRequest request) {
        return userSignUpService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return userSignInService.execute(request);
    }

}
