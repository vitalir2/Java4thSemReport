package task6.factorymethod;

public class Table implements Furniture {

    public static final String WOOD = "wood";

    private String material = WOOD;

    @Override
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
