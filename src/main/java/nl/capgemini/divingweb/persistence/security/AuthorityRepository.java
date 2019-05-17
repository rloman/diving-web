package nl.capgemini.divingweb.persistence.security;

import nl.capgemini.divingweb.model.security.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
}
