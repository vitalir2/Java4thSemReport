package task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    void isFirstSingleton() {
        Singletons.LazyInit first = Singletons.LazyInit.getInstance();
        Singletons.LazyInit second = Singletons.LazyInit.getInstance();
        Assertions.assertEquals(first, second);
    }

    @Test
    void isSecondSingleton() {
        Singletons.Enum first = Singletons.Enum.getInstance();
        Singletons.Enum second = Singletons.Enum.getInstance();
        Assertions.assertEquals(first, second);
    }

    @Test
    void isThirdSingleton() {
        Singletons.ImmediateInit first = Singletons.ImmediateInit.getInstance();
        Singletons.ImmediateInit second = Singletons.ImmediateInit.getInstance();
        Assertions.assertEquals(first, second);
    }
}
