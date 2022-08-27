package com.example.login.damain.user.presentation;

import com.example.login.damain.user.presentation.dto.request.EmailRequest;
import com.example.login.damain.user.presentation.dto.request.LoginRequest;
import com.example.login.damain.user.presentation.dto.request.SignupRequest;
import com.example.login.damain.user.presentation.dto.request.VerifyAuthCodeRequest;
import com.example.login.damain.user.presentation.dto.response.TokenResponse;
import com.example.login.damain.user.service.AuthCodeService;
import com.example.login.damain.user.service.UserSignInService;
import com.example.login.damain.user.service.UserSignUpService;
import com.example.login.damain.user.service.VerifyAuthCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    private final AuthCodeService authCodeService;
    private final VerifyAuthCodeService verifyAuthCodeService;

    @PostMapping("/email")
    public void sendAuthCode(@RequestBody @Valid EmailRequest request) {
        authCodeService.execute(request);
    }

    @PutMapping("/email")
    public void verifyEmail(@RequestBody @Valid VerifyAuthCodeRequest request) {
        verifyAuthCodeService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TokenResponse Signup(@RequestBody @Valid SignupRequest request) {
        return userSignUpService.execute(request);
    }

    @PostMapping("/auth")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return userSignInService.execute(request);
    }

}
