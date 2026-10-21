package com.example.Spring_Boot_Beginner.email;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final Resend resend;

    public EmailService(Resend resend) {
        this.resend = resend;
    }

    public void sendVerificationEmail(String to, String subject, String htmlContent) throws ResendException { CreateEmailOptions params = CreateEmailOptions.builder()
            .from(System.getenv("SUPPORT_EMAIL"))
            .to(to)
            .subject(subject)
            .html(htmlContent)
            .build();
        try {
            resend.emails().send(params);
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}
