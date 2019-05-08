package nl.capgemini.divingweb.generics;

import java.util.ArrayList;
import java.util.List;

public class NumberBox <T extends Number> {

    private List<T> numbers = new ArrayList<>();


    public void add(T t) {
        this.numbers.add(t);
    }

// again bad practice
    public List<T> get() {
        return this.numbers;
    }
}
