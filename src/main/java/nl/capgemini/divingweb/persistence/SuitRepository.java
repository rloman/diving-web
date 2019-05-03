package nl.capgemini.divingweb.persistence;

import nl.capgemini.divingweb.model.Suit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuitRepository extends CrudRepository<Suit, Long> {

//    Iterable<Suit> findByName();


}
