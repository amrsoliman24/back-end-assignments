package entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity(name = "movies_ratings")
public class MoviesRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;

    @Column(name = "rating", precision = 4, scale = 2)
    private BigDecimal rating;


    public MoviesRating(){

    }
    public MoviesRating(user user , BigDecimal rating){
        this.user = user;
        this.rating = rating;

    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public entities.user getUser() {
        return user;
    }

    public void setUser(entities.user user) {
        this.user = user;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}