package com.example.login.damain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class EmailRequest {

    @NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Email(message = "email 형식이 올바르지 않습니다.")
    private String email;

}
