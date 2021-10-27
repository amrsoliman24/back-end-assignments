package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity(name = "gneres")
public class Gnere  {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "gneres", fetch = FetchType.EAGER)
     Set<Movies> Movies = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<entities.Movies> getMovies() {
        return Movies;
    }

    public void setMovies(Set<entities.Movies> movies) {
        Movies = movies;
    }
}