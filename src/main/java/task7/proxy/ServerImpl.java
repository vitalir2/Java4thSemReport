package task7.proxy;

public class ServerImpl implements Server {
    private final String currentData = "data";
    @Override
    public String getData() {
        return currentData;
    }
}
