package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieGenreId implements Serializable {
  /*  @Column(name = "genere_id")
    Integer genereId;
    @Column(name = "movie_id")
    Long movieId;

    public MovieGenreId() {

    }

    public MovieGenreId(Integer genereId, Long movieId) {
        this.genereId = genereId;
        this.movieId = movieId;
    }

    public Integer getGenereId() {
        return genereId;
    }

    public void setGenereId(Integer genereId) {
        this.genereId = genereId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieGenreId that = (MovieGenreId) o;
        return Objects.equals(genereId, that.genereId) && Objects.equals(movieId, that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genereId, movieId);
    }*/
}
