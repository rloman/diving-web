package nl.capgemini.divingweb.model.security;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Authority implements GrantedAuthority {
   
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private Long id;

   @NotNull
   @Enumerated(EnumType.STRING)
   private AuthorityName name;

   @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
   private List<User> users = new ArrayList<>();

    public Long getId() {
       return id;
   }

   public void setName(AuthorityName name) {
       this.name = name;
   }

   public List<User> getUsers() {
       return users;
   }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
