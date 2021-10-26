package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name =  "roleslookup")
public class role {
    @Id
    @Column(name ="id")
    private  long id ;
    @Column(name = "name")
    private String name ;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<user> users;


    public role() {

    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<user> getUsers() {
        return users;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }


}
