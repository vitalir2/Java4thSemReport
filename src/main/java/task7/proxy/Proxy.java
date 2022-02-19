package task7.proxy;

public class Proxy implements Server {
    private final Server realServer = new ServerImpl();
    @Override
    public String getData() {
        return realServer.getData();
    }
}
