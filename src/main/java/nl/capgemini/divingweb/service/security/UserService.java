package nl.capgemini.divingweb.service.security;

import nl.capgemini.divingweb.model.security.User;
import nl.capgemini.divingweb.persistence.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {


    private static final String dummyUser = "john";
    private static final String dummyPassword = "doe";

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void setUp() {

        Optional<User> optionalUser = this.repository.findByUsernameAndPassword(dummyUser, dummyPassword);
        if(!optionalUser.isPresent()) { // OK insert him
            User user = new User();
            user.setUsername(dummyUser);
            user.setPassword(passwordEncoder.encode(dummyPassword));
            this.repository.save(user);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = this.repository.findByUsername(username);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

        return userDetails;
    }
}
