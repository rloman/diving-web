package nl.capgemini.divingweb.service.security;

import nl.capgemini.divingweb.model.security.Authority;
import nl.capgemini.divingweb.model.security.AuthorityName;
import nl.capgemini.divingweb.model.security.User;
import nl.capgemini.divingweb.persistence.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {


    private static final String dummyUser = "john";
    private static final String dummyPassword = "doe";

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void setUp() {

        Optional<User> optionalUser = this.repository.findByUsernameAndPassword(dummyUser, dummyPassword);
        if(!optionalUser.isPresent()) { // OK insert him
            User user = new User();
            user.setUsername(dummyUser);
            user.setPassword(passwordEncoder.encode(dummyPassword));
            Authority a = new Authority();
            a.setName(AuthorityName.API);
            this.authorityService.save(a);

            user.getAuthorities().add(a);
            a.getUsers().add(user);
            this.repository.save(user);
            this.authorityService.save(a);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = this.repository.findByUsername(username);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());

        return userDetails;
    }
}
