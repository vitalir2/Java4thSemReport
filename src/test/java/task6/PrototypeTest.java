package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task6.prototype.A;
import task6.prototype.Symbol;
import task6.prototype.Y;

public class PrototypeTest {
    @Test
    void test() {
        Symbol symbol1 = new A();
        Symbol symbol2 = new Y();
        Assertions.assertTrue(symbol1.clone() instanceof A);
        Assertions.assertTrue(symbol2.clone() instanceof Y);
    }
}
