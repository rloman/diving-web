package nl.capgemini.divingweb.generics.listing;

import java.util.List;

public class AnimalService {


    // invoke this method for assign with List<Dog> and List<Animal>
    public void animalFeeder(List <? extends Animal> animalList) {


//        animalList.add(new Dog()); // compile error
//        animalList.add(new Cat()); // compile error //

        animalList.forEach( animal -> {
            animal.eat();
        });

    }


}
