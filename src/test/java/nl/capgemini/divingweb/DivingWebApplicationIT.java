package nl.capgemini.divingweb;

import nl.capgemini.divingweb.model.Color;
import nl.capgemini.divingweb.model.Size;
import nl.capgemini.divingweb.model.Suit;
import nl.capgemini.divingweb.service.SuitService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integrationtest")
public class DivingWebApplicationIT {


    @Autowired
    private SuitService suitService;

    @Test
    public void contextLoads() {

        // but still this tries to run my Spring Boot container because this
        // is a test method ... and Spring will than start ...

    }

    @Test
    public void testCreateAndTestTheSave() {

        // status quo // given
        int numberOfSuits = 0;

        {
            Iterable<Suit> suits = this.suitService.findAll();
            for (Suit suit : suits) {
                numberOfSuits++;
            }
        }


        //when
        {
            Suit suit = new Suit();
            suit.setSize(Size.S);
            suit.setColor(Color.BLACK);

            this.suitService.save(suit);
        }

        {
            Suit suit = new Suit();
            suit.setColor(Color.RED);
            suit.setSize(Size.LARGE);

            this.suitService.save(suit);
        }

        int newNumberOfSuits = 0;
        {

            Iterable<Suit> suits = this.suitService.findAll();
            for (Suit suit : suits) {
                newNumberOfSuits++;
            }


        }

        // then
        Assert.assertEquals(newNumberOfSuits, numberOfSuits + 2);


    }

    @Test
    public void testSaveSomeAndUpdateSomeAndTestTheUpdate() {

        long savedId = 0;

        {
            Suit suit = new Suit();
            suit.setSize(Size.S);
            suit.setColor(Color.BLACK);

            savedId = this.suitService.save(suit).getId();
        }

        {
            Optional<Suit> optionalSuit = this.suitService.findById(savedId);

            Assert.assertTrue(optionalSuit.isPresent());

            Suit suit = optionalSuit.get();

            suit.setSize(Size.MEDIUM);
            suit.setColor(Color.RED);

            this.suitService.save(suit);
        }

        {
            Optional<Suit> optionalSuit = this.suitService.findById(savedId);

            Assert.assertTrue(optionalSuit.isPresent());

            Suit suit = optionalSuit.get();

            Assert.assertEquals(Size.MEDIUM, suit.getSize());
            Assert.assertEquals(Color.RED, suit.getColor());
        }

    }


    @Test
    public void testDelete() {
        // delete
        {
            Suit suit = new Suit();
            suit.setSize(Size.S);
            suit.setColor(Color.BLACK);

            long savedId = this.suitService.save(suit).getId();

            Assert.assertNotEquals(savedId, 0);

            this.suitService.deleteById(savedId);

            Optional<Suit> optionalSuit = this.suitService.findById(savedId);
            Assert.assertFalse(optionalSuit.isPresent());
        }
    }


}
