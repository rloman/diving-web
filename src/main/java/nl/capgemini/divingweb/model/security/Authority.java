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

   public Authority() {

   }

    public Authority(@NotNull AuthorityName name) {
        this.name = name;
    }

    public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public AuthorityName getName() {
       return name;
   }

   public void setName(AuthorityName name) {
       this.name = name;
   }

   public List<User> getUsers() {
       return users;
   }

   public void setUsers(List<User> users) {
       this.users = users;
   }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
