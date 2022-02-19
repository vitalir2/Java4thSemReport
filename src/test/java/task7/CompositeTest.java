package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task7.composite.Div;
import task7.composite.Tag;
import task7.composite.TextElement;

public class CompositeTest {
    @Test
    void test() {
        Tag main = new Div();
        main.add(new TextElement("Hello, guest!"));
        Tag innerTag = new Div();
        innerTag.add(new TextElement("How are you?"));
        main.add(innerTag);
        Assertions.assertEquals("Hello, guest! How are you?  ", main.toString());
    }
}
