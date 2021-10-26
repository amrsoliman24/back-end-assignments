package entities;

import javax.persistence.*;

@Table(name = "improper_flagging", indexes = {
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "movie_id", columnList = "movie_id")
})
@Entity
public class ImproperFlagging {
    @Id
    private long id ;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
   public ImproperFlagging(){

   }
    public ImproperFlagging(user user){
    this.user = user ;
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
}