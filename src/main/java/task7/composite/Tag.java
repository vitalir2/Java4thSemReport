package task7.composite;

public interface Tag {
    String toString();
    void add(Tag tag);
    void remove(Tag tag);
    Tag getChild(int index);
}
