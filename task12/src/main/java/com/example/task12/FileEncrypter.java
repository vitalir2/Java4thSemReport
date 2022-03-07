package com.example.task12;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileEncrypter {

    private final SecretKey secretKey;
    private final Cipher cipher;

    public FileEncrypter(SecretKey secretKey, String transformation) {
        this.secretKey = secretKey;
        try {
            this.cipher = Cipher.getInstance(transformation);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal algo or padding");
        }
    }

    @SneakyThrows
    public void encrypt(Path input, Path output) {
        byte[] content;
        try (FileInputStream fileIn = new FileInputStream(input.toFile())) {
            content = fileIn.readAllBytes();
        } catch (IOException e) {
            content = "null".getBytes();
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        byte[] iv = cipher.getIV();

        try (FileOutputStream fileOut = new FileOutputStream(output.toFile());
            CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher)) {
                fileOut.write(iv);
                cipherOut.write(content);
        }
    }
}
