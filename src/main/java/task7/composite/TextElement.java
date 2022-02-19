package task7.composite;

public class TextElement implements Tag {
    private final String content;

    public TextElement(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public void add(Tag tag) {
    }

    @Override
    public void remove(Tag tag) {
    }

    @Override
    public Tag getChild(int index) {
        return null;
    }
}
