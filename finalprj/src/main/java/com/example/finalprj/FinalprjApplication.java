package com.example.finalprj;

import com.example.finalprj.service.EmailService;
import com.example.finalprj.service.FakeEmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalprjApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalprjApplication.class, args);
    }

    @Bean
    EmailService emailService() {
        return new FakeEmailService();
    }
}
