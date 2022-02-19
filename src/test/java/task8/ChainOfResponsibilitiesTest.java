package task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task8.chain.CompositeHandler;
import task8.chain.PrintHandler;

public class ChainOfResponsibilitiesTest {
    @Test
    void test() {
        CompositeHandler mainHandler = new CompositeHandler();
        mainHandler.addHandler(new PrintHandler());
        mainHandler.addHandler(new PrintHandler());
        Assertions.assertDoesNotThrow(() -> mainHandler.handleRequest("Hello!"));
    }
}
