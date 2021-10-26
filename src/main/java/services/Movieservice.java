package services;

import Dtos.MoviegneresDto;
import entities.Movies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public interface Movieservice {
    public List<Movies> fetchMovies(int page , int size);
    public List<Movies>fetchTopMovies();
    public boolean rateMovie(Long movieId , String User,String rateValue);

}
