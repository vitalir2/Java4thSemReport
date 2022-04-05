package com.example.task12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Task12Application {

    private static String openedFileName;
    private static String encryptedFileName;

    public static void main(String[] args) {
        openedFileName = args[0];
        encryptedFileName = args[1];
        SpringApplication.run(Task12Application.class, args);
    }

    @Bean
    public FileHandler fileHandler() {
        return new FileHandler(openedFileName, encryptedFileName);
    }
}
