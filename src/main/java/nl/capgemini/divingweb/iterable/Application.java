package nl.capgemini.divingweb.iterable;


import java.util.Iterator;

public class Application {

    public static void main(String[] args) {

        BoxIterable<String> names = new BoxIterable<>();

        names.add("T");

        Iterator<String> iterator = names.iterator();

        iterator.remove();

        for(String name: names) {
			System.out.println(name);
        }

    }
}
