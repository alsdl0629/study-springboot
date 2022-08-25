package com.example.login.damain.user.api;

import com.example.login.damain.user.api.dto.request.SignupRequest;
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

}
