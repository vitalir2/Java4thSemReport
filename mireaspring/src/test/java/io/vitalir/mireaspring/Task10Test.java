package io.vitalir.mireaspring;

import io.vitalir.mireaspring.model.Senior;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(args = {"senior"})
public class Task10Test {

    private static final String SENIOR = "senior";

    @Test
    void checkIsValidProgrammer(ApplicationContext context, @Autowired ApplicationArguments args) {
        assertThat(args.getNonOptionArgs()).containsExactly(SENIOR);
        assertThat(context.getBean(SENIOR)).hasSameClassAs(new Senior());
    }
}
