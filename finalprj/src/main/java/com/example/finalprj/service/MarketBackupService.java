package com.example.finalprj.service;

import com.example.finalprj.Configuration;
import com.example.finalprj.model.Market;
import com.example.finalprj.repository.MarketRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
public class MarketBackupService implements BackupService {

    private final MarketRepository marketRepository;

    public MarketBackupService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @SneakyThrows
    @Override
    public void backupData() {
        var markets = marketRepository.findAll();
        var backupFilePath = Path.of(Configuration.BACKUP_DIR + "/market.txt");
        for (Market market : markets) {
            Files.write(backupFilePath,
                    market.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE
            );
        }
    }
}
