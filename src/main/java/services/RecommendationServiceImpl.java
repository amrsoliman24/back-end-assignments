package services;

import entities.Gnere;
import entities.Movies;
import entities.user;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reposotories.GnereRepo;
import reposotories.Movierepo;
import reposotories.userRepo;
import security.JwtManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    Movierepo movierepo;
    @Autowired
    GnereRepo gnereRepo;
    @Autowired
    JwtManager jwtManager;
    @Autowired
    userRepo UserRepo;
    @Override
    public Set<Movies> recommendMoviesPerUserRating(String Auth) {
        user User = UserRepo.findByusername(jwtManager.extractUsername(Auth.substring(7)));
        Long userId = User.getId();
       Set<Movies> prefeeredMovies = new HashSet<>();
        Set<Gnere> recommendedGneres =  movierepo.getUserHighlyRatedMovies(userId);
        recommendedGneres.forEach(gnere -> {
            prefeeredMovies.addAll(movierepo.findBygneres(gnere.getId()));


        });
        return prefeeredMovies;
    }
}
