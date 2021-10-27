package services;

import entities.Gnere;
import entities.Movies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface RecommendationService {
    public Set<Movies> recommendMoviesPerUserRating(String Auth);
}
