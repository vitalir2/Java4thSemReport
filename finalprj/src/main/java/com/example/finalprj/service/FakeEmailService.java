package com.example.finalprj.service;

import org.springframework.scheduling.annotation.Async;

public class FakeEmailService implements EmailService {

    @Override
    @Async
    public void sendEmailMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}
