package nl.capgemini.divingweb.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> content = new ArrayList<>();


    // bad practice. Will improve later ... (done 8-05-2019(
    // bad since we are exposing the List here and than we could
    // per abuse or with criminal intent remove some from the List ... 
    public List<T> get() {
        return this.content;
    }

    public void add(T t) {
        this.content.add(t);
    }
}
