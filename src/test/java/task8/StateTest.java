package task8;

import org.junit.jupiter.api.Test;
import task8.state.Enabled;
import task8.state.Television;

public class StateTest {
    @Test
    void test() {
        Television television = new Television();
        television.getState().handle();
        television.getState().handle();
        television.setState(new Enabled());
        television.getState().handle();
        television.getState().handle();
    }
}
