package nl.capgemini.divingweb.generics.listing;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        AnimalService service = new AnimalService();

        Dog a = new Dog();
        List<Dog> animalList = new ArrayList<>(); // read only
        animalList.add(a);

        service.animalFeeder(animalList);

        System.out.println(animalList);

    }
}
