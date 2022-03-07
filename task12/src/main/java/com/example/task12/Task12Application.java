package com.example.task12;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
