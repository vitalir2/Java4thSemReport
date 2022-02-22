package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// variant 13
public class Task3Test {

    private static final int SIZE = 1_000_000;
    private static final int SLEEP_MILLIS = 1_000;
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);
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

    @Test
    void addAllItemsInSet() {
        executor.execute(() -> {
            for (int i = 0; i < SIZE / 2; ++i) {
                strings.add(i + "");
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < SIZE / 2; ++i) {
                strings.add(SIZE / 2 + i + "");
            }
        });
        try {
            TimeUnit.MILLISECONDS.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(SIZE, strings.size());
    }

    @Test
    void addAllItemsInList() {
        executor.execute(() -> {
            for (int i = 0; i < SIZE / 2; ++i) {
                stringList.add(i + "");
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < SIZE / 2; ++i) {
                stringList.add(SIZE / 2 + i + "");
            }
        });
        try {
            TimeUnit.MILLISECONDS.sleep(SLEEP_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(SIZE, stringList.size());
    }
}
