package io.vitalir.mireaspring;

import io.vitalir.mireaspring.model.Programmer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Variant 13
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MireaspringApplication {

    private static final ApplicationContext configContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(MireaspringApplication.class, args);
        String beanName = args[0];
        Programmer programmer = (Programmer) configContext.getBean(beanName);
        programmer.doCoding();
    }
}
