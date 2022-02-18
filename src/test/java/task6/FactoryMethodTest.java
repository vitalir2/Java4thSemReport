package task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task6.factorymethod.Furniture;
import task6.factorymethod.FurnitureFactory;
import task6.factorymethod.Table;
import task6.factorymethod.TableFactory;

public class FactoryMethodTest {
    @Test
    void factoryMethod() {
        FurnitureFactory furnitureFactory = new TableFactory();
        Furniture furniture = furnitureFactory.create();
        Assertions.assertEquals(Table.WOOD, furniture.getMaterial());
    }
}
