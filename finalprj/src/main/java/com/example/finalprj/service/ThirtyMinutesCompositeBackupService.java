package com.example.finalprj.service;

import lombok.SneakyThrows;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.example.finalprj.Configuration.BACKUP_DIR;

@Service
@ManagedResource
public class ThirtyMinutesCompositeBackupService implements BackupService {

    private final List<BackupService> backupServices;

    public ThirtyMinutesCompositeBackupService(List<BackupService> backupServices) {
        this.backupServices = backupServices;
    }

    @SneakyThrows
    @Scheduled(fixedRate = 30, timeUnit = TimeUnit.MINUTES)
    @Override
    @ManagedOperation
    public void backupData() {
        var backupPath = Path.of(BACKUP_DIR);
        System.out.println(BACKUP_DIR);

        Files.walk(backupPath)
                .forEach(file -> {
                    try {
                        if (!Files.isDirectory(file)) {
                            Files.delete(file);
                        }
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                });

        for (BackupService backupService : backupServices) {
            backupService.backupData();
        }
    }
}
