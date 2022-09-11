package com.example.login.damain.user.facade;

import com.example.login.damain.user.domain.AuthCode;
import com.example.login.damain.user.domain.repository.AuthCodeRepository;
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

        if(!isValid(email)) {
            throw new RuntimeException("Wrong Email");
        }

        String code = createKey();
        jmsUtil.sendEmail(email, code);

        authCodeRepository.save(AuthCode.builder()
                .email(email)
                .code(code)
                .build());
    }

    private boolean isValid(String email) {
        return email.endsWith("@dsm.hs.kr");
    }

    private String createKey() {
        return RandomStringUtils.randomNumeric(6);
    }

}
