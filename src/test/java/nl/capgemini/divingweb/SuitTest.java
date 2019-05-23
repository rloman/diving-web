package nl.capgemini.divingweb;

import nl.capgemini.divingweb.model.Size;
import nl.capgemini.divingweb.model.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuitTest {

    private Suit suit;

    @Before
    public void setup() {
        this.suit = new Suit();
    }

    @Test
    public void testGetSet() {

        suit.setSize(Size.MEDIUM);

        Assert.assertEquals(Size.MEDIUM, suit.getSize());

    }
}
