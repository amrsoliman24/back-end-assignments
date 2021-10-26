package Dtos;

import entities.Movies;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MoviegneresDto {
    private long id ;
    private  String name ;
    private  String description;
    private BigDecimal rating;

    public MoviegneresDto(Movies movie) {

        this.id = movie.getId();
        this.name = movie.getName();
        this.description = movie.getDescription();
        this.rating = movie.getRating();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public MoviegneresDto(){}

    public  static List<MoviegneresDto> Serlaizemovies(List<Movies> movies) {
        List<MoviegneresDto> serlaizedmovis = new ArrayList<>();
        movies.forEach( Movie ->{
            MoviegneresDto serlMovie = new MoviegneresDto(Movie);
            serlaizedmovis.add(serlMovie);
                 }
        );
        return serlaizedmovis;
    }




}
