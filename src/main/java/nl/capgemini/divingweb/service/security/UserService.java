package nl.capgemini.divingweb.service.security;

import nl.capgemini.divingweb.model.security.User;
import nl.capgemini.divingweb.persistence.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class UserService {


    private static final String dummyUser = "john";
    private static final String dummyPassword = "doe";

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void setUp() {

        Optional<User> optionalUser = this.repository.findByUsernameAndPassword(dummyUser, dummyPassword);
        if(!optionalUser.isPresent()) { // OK insert him
            User user = new User();
            user.setUsername(dummyUser);
            user.setPassword(dummyPassword);
            this.repository.save(user);
        }

    }

    public boolean authenticate(String username, String password) {
        return this.repository.findByUsernameAndPassword(username, password).isPresent();
    }
}
