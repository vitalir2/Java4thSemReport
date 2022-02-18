package task6.abstractfactory;

public class RedFruitFactory implements FruitFactory {
    @Override
    public Apple createApple() {
        return new Fuji();
    }

    @Override
    public Orange createOrange() {
        return new BloodOrange();
    }
}
