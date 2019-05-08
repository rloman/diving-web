package nl.capgemini.divingweb.generics;

import nl.capgemini.divingweb.model.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        demoList();
        demoIterable();

    }

    public static void demoList() {
        List<Integer> numbers = new ArrayList<>();

        numbers.addAll(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233));

        Box<String> stringBox = new Box<>();
        stringBox.add("A");

        System.out.println(stringBox.get());

        Box<Suit> suitBox = new Box<>();
        suitBox.add(new Suit());

        System.out.println(suitBox.get());

        System.out.println(suitBox.get());
    }

    public static void demoIterable() {
        NumberBox<Long> numberBox = new NumberBox<>();

        Box<String> names = new Box<>();

        names.add("A");
        names.add("B");
        names.add("C");

        names.get().remove("B");

        for (String name : names.get()) {
            System.out.println(name);
        }
    }
}
