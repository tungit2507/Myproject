package com.asm.until.SendMail;

import org.springframework.stereotype.Service;


@Service
public interface EmailService {
    String sendSimpleMail(EmailDetails details);
}
