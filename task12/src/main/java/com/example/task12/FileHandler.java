package com.example.task12;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.crypto.KeyGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {

    private static final String MODULE_PATH = "task12/src/main/";
    private static final String FILES_PATH = "resources/static/";

    private Path openedFile;
    private Path hashedFile;
    private final String openedFileName;
    private final String encryptedFileName;

    public FileHandler(String openedFileName, String encryptedFileName) {
        this.openedFileName = openedFileName;
        this.encryptedFileName = encryptedFileName;
    }

    @PostConstruct
    private void onConstruct() {
        openedFile = Path.of(MODULE_PATH + FILES_PATH + openedFileName);
        try {
            hashedFile = Files.createFile(Path.of(MODULE_PATH + FILES_PATH + encryptedFileName));
            hashFile(openedFile, hashedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void onDestroy() {
        try {
            Files.deleteIfExists(openedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private void hashFile(Path input, Path output) {
        FileEncrypter encrypter = new FileEncrypter(
                KeyGenerator.getInstance("AES").generateKey(),
                "AES/CBC/PKCS5Padding"
        );
        encrypter.encrypt(input, output);
    }
}
