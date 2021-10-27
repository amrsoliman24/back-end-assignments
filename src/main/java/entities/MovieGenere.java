package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/*@Table(name = "movie_generes", indexes = {
        @Index(name = "genere_id", columnList = "genere_id")
})*/

public class MovieGenere {
  /*  @EmbeddedId
    MovieGenreId id = new MovieGenreId();
    @JsonIgnore
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movies movie;
    @JsonIgnore
    @ManyToOne
    @MapsId("genereId")
    @JoinColumn(name = "genere_id")
    private Gnere gnere;

    public MovieGenere(){

    }

    public MovieGenere(Integer gnere_id ,Long movie_id) {
        this.id = new MovieGenreId(gnere_id,movie_id);

    }

    public MovieGenere(Gnere gnere){
        this.gnere = gnere;

    }


    public MovieGenreId getId() {
        return id;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public Gnere getGnere() {
        return gnere;
    }

    public void setGnere(Gnere gnere) {
        this.gnere = gnere;
    }

    public void setId(MovieGenreId id) {
        this.id = id;
    }*/
}