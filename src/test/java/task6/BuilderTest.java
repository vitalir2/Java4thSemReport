package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task6.builder.Home;

public class BuilderTest {
    private static final int EXPECTED_FLOORS_COUNT = 2;

    @Test
    void test() {
        Home home = new Home.BuilderImpl()
                .addFoundation()
                .addFloor()
                .addFloor()
                .addRoof()
                .build();
        Assertions.assertEquals(EXPECTED_FLOORS_COUNT, home.getFloorsCount());
    }
}
