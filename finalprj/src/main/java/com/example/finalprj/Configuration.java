package com.example.finalprj;

import java.nio.file.Path;

public class Configuration {

    private Configuration() {

    }

    public static final String PROJECT_DIR = Path.of(".").normalize().toFile().getAbsolutePath();
    public static final String BACKUP_DIR = PROJECT_DIR + "/finalprj/src/main/resources/backup";
}
