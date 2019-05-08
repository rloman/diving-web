package nl.capgemini.divingweb.persistence.security;

import nl.capgemini.divingweb.model.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

   Optional<User> findByUsernameAndPassword(String username, String password);

}
