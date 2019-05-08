package nl.capgemini.divingweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Suit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Size size;
    private Color color;

    public Suit() {
        this.setSize(Size.MEDIUM);
        this.setColor(Color.BLACK);
    }

    public long getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "size=" + size +
                ", color=" + color +
                '}';
    }
}
