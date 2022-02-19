package task7.composite;

import java.util.*;

public class Div implements Tag {
    private final List<Tag> innerTags = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Tag tag: innerTags) {
            result.append(tag.toString()).append(" ");
        }
        return result.toString();
    }

    @Override
    public void add(Tag tag) {
        innerTags.add(tag);
    }

    @Override
    public void remove(Tag tag) {
        innerTags.remove(tag);
    }

    @Override
    public Tag getChild(int index) {
        return innerTags.get(index);
    }
}
