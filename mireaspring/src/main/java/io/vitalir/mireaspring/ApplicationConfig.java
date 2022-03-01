package io.vitalir.mireaspring;

import io.vitalir.mireaspring.model.Junior;
import io.vitalir.mireaspring.model.Middle;
import io.vitalir.mireaspring.model.Programmer;
import io.vitalir.mireaspring.model.Senior;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Programmer junior() {
        return new Junior();
    }

    @Bean
    public Programmer middle() {
        return new Middle();
    }

    @Bean
    public Programmer senior() {
        return new Senior();
    }
}
