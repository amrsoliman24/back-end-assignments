package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/*@Table(name = "movie_generes", indexes = {
        @Index(name = "genere_id", columnList = "genere_id")
})*/
@Entity(name = "movie_generes")
public class MovieGenere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genere_id")
    private Gnere gnere;

    public MovieGenere(){

    }
    public MovieGenere(Gnere gnere){
        this.gnere = gnere;

    }


    public Integer getId() {
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

    public void setId(Integer id) {
        this.id = id;
    }
}