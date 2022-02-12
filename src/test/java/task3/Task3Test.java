package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// variant 13
public class Task3Test {

    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
    private static final Object monitor = new Object();
    private final Set<String> strings = new SetSemaphore<>();
    private final List<String> stringList = new ListWithLock<>();

    @Test
    void addInSetWithSemaphore() {
        executor.execute(() -> strings.add("first"));
        executor.execute(() -> Assertions.assertTrue(strings.contains("first")));
    }

    @Test
    void addAndRemoveAllInSet() {
        executor.execute(() -> {
            for (int i = 0; i < 1000; ++i) {
                Assertions.assertTrue(strings.add("" + i));
            }
        });
        Assertions.assertDoesNotThrow(() -> executor.execute(() -> {
            for (String elem : strings) {
                // Nothing to do.. Alright!
            }
        }));
    }

    @Test
    void addInListWithSemaphore() {
        executor.execute(() -> stringList.add("first"));
        executor.execute(() -> Assertions.assertTrue(stringList.contains("first")));
    }

    @Test
    void addAndRemoveAllInList() {
        executor.execute(() -> {
            for (int i = 0; i < 1000; ++i) {
                Assertions.assertTrue(stringList.add("" + i));
            }
        });
        Assertions.assertDoesNotThrow(() -> executor.execute(() -> {
            for (String elem : stringList) {
                // Nothing to do.. Alright!
            }
        }));
    }
}
