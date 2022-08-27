package com.example.login.damain.user.facade;

import com.example.login.damain.auth.entity.AuthCode;
import com.example.login.damain.auth.entity.repository.AuthCodeRepository;
import com.example.login.damain.user.exception.InvalidAuthCodeException;
import com.example.login.global.util.JmsUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthCodeFacade {

    private final AuthCodeRepository authCodeRepository;
    private final JmsUtil jmsUtil;

    public AuthCode getAuthCodeById(String email) {
        return authCodeRepository.findById(email)
                .orElseThrow(() -> InvalidAuthCodeException.EXCEPTION);
    }

    public boolean isVerify(String email) {
        return getAuthCodeById(email).isVerify();
    }

    public void sendEmail(String email) {

        String code = getCode(createKey());
        jmsUtil.sendEmail(email, code);

        authCodeRepository.save(AuthCode.builder()
                .email(email)
                .code(code)
                .build());
    }

    private String createKey() {
        return RandomStringUtils.randomNumeric(6);
    }

    private String getCode(String key) {
        return key.substring(0, 3) + "-" + key.substring(3, 6);
    }

}
