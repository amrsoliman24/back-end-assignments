package services;

import entities.Movies;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ImproperMovieService {
    public boolean addUserImproperFlag(Long id , String Auth);
    public boolean markMovieImproper(Long movieid);
    public Set<Movies>impropratemovies();
}
