package entities;

import Dtos.MovieDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;
    @Column(name = "name" , unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private BigDecimal rating;
    @Column(name = "posterpath")
    private  String posterPath;
    @Column(name = "improper")
    private boolean improper;
    @Column(name = "language")
    private String language;
    @Column(name = "Source")
    private String Source;
    @Column(name = "release_date")
    private Date releaseDate;


    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MoviesRating> usersRating  ;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<ImproperFlagging> userImproperflaging ;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<MovieGenere> Generes  ;



    public Movies() {
    }
    public boolean addMovieRating(MoviesRating moviesRating) {
        moviesRating.setMovie(this);
        this.usersRating= new HashSet<>();
        this.usersRating.add(moviesRating);
        return true ;
    }
    public boolean adduserImproprateflag(ImproperFlagging ImproperFlag) {
        ImproperFlag.setMovie(this);
        this.usersRating = new HashSet<>();
        this.userImproperflaging.add(ImproperFlag);
        return true ;
    }
    public boolean addgnere(MovieGenere movieGenere) {
        movieGenere.setMovie(this);
        this.Generes = new HashSet<>();
        this.Generes.add(movieGenere);
        return true ;
    }

    public Movies(MovieDto movie){
        this.name = movie.getTitle();
        this.language = movie.getOriginal_language();
        this.posterPath = movie.getPoster_path();
        this.releaseDate = movie.getRelease_date();
        this.description = movie.getOverview().replaceAll("[^A-Za-z0-9]","");


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public boolean isImproper() {
        return improper;
    }

    public void setImproper(boolean improper) {
        this.improper = improper;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<MovieGenere> getGeneres() {
        return Generes;
    }

    public void setGeneres(Set<MovieGenere> generes) {
        Generes = generes;
    }

    public Set<MoviesRating> getUsersRating() {
        return usersRating;
    }

    public void setUsersRating(Set<MoviesRating> usersRating) {
        this.usersRating = usersRating;
    }

    public Set<ImproperFlagging> getUserImproperflaging() {
        return userImproperflaging;
    }

    public void setUserImproperflaging(Set<ImproperFlagging> userImproperflaging) {
        this.userImproperflaging = userImproperflaging;
    }
}
