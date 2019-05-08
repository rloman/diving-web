package nl.capgemini.divingweb.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoxIterable <T> implements Iterable<T> {

    private List<T> content = new ArrayList<>();

    public void add(T t) {
        this.content.add(t);
    }

	// this is the Iterator pattern ... nice => https://en.wikipedia.org/wiki/Iterator_pattern
    @Override
    public Iterator<T> iterator() {
        return this.content.iterator();
    }
}
