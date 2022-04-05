package com.example.finalprj.service;

import com.example.finalprj.Configuration;
import com.example.finalprj.model.Product;
import com.example.finalprj.repository.ProductRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class ProductBackupService implements BackupService {

    private final ProductRepository productRepository;

    public ProductBackupService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @SneakyThrows
    @Override
    public void backupData() {
        var products = productRepository.findAll();
        var backupFilePath = Path.of(Configuration.BACKUP_DIR + "/product.txt");
        for (Product product : products) {
            Files.write(backupFilePath,
                    product.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE
            );
        }
    }
}
