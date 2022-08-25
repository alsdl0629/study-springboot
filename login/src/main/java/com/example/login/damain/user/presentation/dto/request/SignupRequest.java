package com.example.login.damain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignupRequest {

    @NotBlank(message = "email은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotBlank(message = "password는 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Length(min = 8, max = 15, message = "password는 8글자 이상, 15글자 이하여야 합니다.")
    private String password;

    @NotBlank(message = "name은 Null 또는 공백 또는 띄어쓰기를 허용하지 않습니다.")
    @Length(max = 10, message = "name은 10글자 이하여야 합니다.")
    private String name;

}
