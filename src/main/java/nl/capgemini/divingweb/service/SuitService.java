package nl.capgemini.divingweb.service;

import nl.capgemini.divingweb.model.Suit;
import nl.capgemini.divingweb.persistence.SuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SuitService {

    private SuitRepository suitRepository;

    public SuitService(SuitRepository suitRepository) {
        this.suitRepository = suitRepository;
    }

    public Optional<Suit> edit(long id, Suit suitIn) {
        // first get the target
        Optional<Suit> optionalTarget = findById(id);
        if(optionalTarget.isPresent()) {
            Suit target = optionalTarget.get();
            target.setColor(suitIn.getColor());
            target.setSize(suitIn.getSize());

            this.suitRepository.save(target);

            return Optional.of(target);
        }
        else {
            return Optional.empty();
        }
    }

    public Suit save(Suit suit) {
        return suitRepository.save(suit);
    }

    public Optional<Suit> findById(Long aLong) {
        return suitRepository.findById(aLong);
    }

    public Iterable<Suit> findAll() {
        return suitRepository.findAll();
    }

    public void deleteById(Long aLong) {
        suitRepository.deleteById(aLong);
    }
}
