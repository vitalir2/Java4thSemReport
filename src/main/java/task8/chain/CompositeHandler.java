package task8.chain;

import java.util.ArrayList;
import java.util.List;

public class CompositeHandler implements Handler {
    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    @Override
    public void handleRequest(String request) {
        for (Handler handler: handlers) {
            handler.handleRequest(request);
        }
    }
}
