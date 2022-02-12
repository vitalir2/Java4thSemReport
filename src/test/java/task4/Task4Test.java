package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;

public class Task4Test {

    private String str;
    private final ExecutorService executorService = new MyExecutorService(2);

    @Test
    void executeSuccessful() {
        executorService.execute(() -> str = "Hello");
        Assertions.assertNull(str);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("Hello", str);
    }
}
