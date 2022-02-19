package task8.state;

public class Enabled implements TelevisionState {
    @Override
    public void handle() {
        System.out.println("Enabled..");
    }
}
