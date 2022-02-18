package task6.factorymethod;

public class TableFactory implements FurnitureFactory {
    @Override
    public Furniture create() {
        return new Table();
    }
}
