package task8.chain;

public class PrintHandler implements Handler {
    @Override
    public void handleRequest(String request) {
        System.out.println(request);
    }
}
