package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task7.proxy.Proxy;
import task7.proxy.Server;

public class ProxyTest {
    @Test
    void test() {
        Server server = new Proxy();
        Assertions.assertEquals("data", server.getData());
    }
}
