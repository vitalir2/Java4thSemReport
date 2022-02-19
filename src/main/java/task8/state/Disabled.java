package task8.state;

public class Disabled implements TelevisionState {
    @Override
    public void handle() {
        System.out.println("Disabled..");
    }
}
