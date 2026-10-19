package com.example.Spring_Boot_Beginner.config;

import com.resend.Resend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EmailConfiguration {
    @Bean
    public Resend resend() {
        return new Resend(System.getenv("RESEND_API_KEY"));
    }
}
