package com.example.login.global.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class JmsUtil {

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;

    public void sendEmail(String email, String code) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,false,"UTF-8");

            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject("Test 이메일 인증");
            mimeMessageHelper.setText(code);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.getStackTrace();
        }
    }

}
