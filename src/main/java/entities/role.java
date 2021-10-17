package entities;

import entities.Employees;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "roleslookup")
public class role {
    @Id
    @Column(name = "role_id")
    private long id ;
    @Column(name = "rolename ")
    private String name;
    @OneToMany(mappedBy = "role")
    List<Employees> employeeroles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Employees> getEmployeeroles() {
        return employeeroles;
    }

    public void setEmployeeroles(List<Employees> employeeroles) {
        this.employeeroles = employeeroles;
    }
}