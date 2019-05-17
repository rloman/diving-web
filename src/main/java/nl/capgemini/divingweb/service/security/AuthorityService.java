package nl.capgemini.divingweb.service.security;

import nl.capgemini.divingweb.model.security.Authority;
import nl.capgemini.divingweb.persistence.security.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority a) {
        return this.authorityRepository.save(a);
    }
}
