package task8.state;

public class Television {
    private TelevisionState state = new Disabled();


    public TelevisionState getState() {
        return state;
    }

    public void setState(TelevisionState state) {
        this.state = state;
    }
}
