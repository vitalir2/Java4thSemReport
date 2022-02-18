package task6.abstractfactory;

public class GreenFruitFactory implements FruitFactory {
    @Override
    public Apple createApple() {
        return new GrannySmith();
    }

    @Override
    public Orange createOrange() {
        return new TingedOrange();
    }
}
