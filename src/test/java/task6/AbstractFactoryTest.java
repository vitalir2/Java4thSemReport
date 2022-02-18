package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task6.abstractfactory.Colors;
import task6.abstractfactory.FruitFactory;
import task6.abstractfactory.GreenFruitFactory;
import task6.abstractfactory.RedFruitFactory;

public class AbstractFactoryTest {
    @Test
    void test() {
        FruitFactory fruitFactoryGreen = new GreenFruitFactory();
        FruitFactory fruitFactoryRed = new RedFruitFactory();
        Assertions.assertEquals(Colors.RED, fruitFactoryRed.createApple().getColor());
        Assertions.assertEquals(Colors.RED, fruitFactoryRed.createOrange().getColor());
        Assertions.assertEquals(Colors.GREEN, fruitFactoryGreen.createApple().getColor());
        Assertions.assertEquals(Colors.GREEN, fruitFactoryGreen.createOrange().getColor());
    }
}
