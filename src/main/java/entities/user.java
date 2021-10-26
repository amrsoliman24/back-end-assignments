package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "user")
public class user {
    @Id
    @Column(name = "id")
   private Long id ;
    @Column(name = "username")
    private String username ;
    @Column(name =  "email")
    private String email ;
    @Column(name = "password")
    private String password ;
    @Column(name = "enabled")
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<MoviesRating> MovieRating = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<ImproperFlagging> userImproperflaging = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "role_id")
    private role role;

    public user() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public entities.role getRole() {
        return role;
    }

    public void setRole(entities.role role) {
        this.role = role;
    }
}
