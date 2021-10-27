package services;

import entities.ImproperFlagging;
import entities.Movies;
import entities.user;
import security.JwtManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reposotories.Movierepo;

import reposotories.userRepo;

import java.util.Optional;

@Service
public class ImproperMovieServiceImp implements ImproperMovieService{


    @Autowired
    Movierepo movierepo;
    @Autowired
    JwtManager jwtManager;
    @Autowired
    userRepo UserRepo;


    @Override
    public boolean addUserImproperFlag(Long movieid, String Auth) {
        String username = jwtManager.extractUsername(Auth.substring(7));
        Movies movie =   getmovie(movieid);
        user user = UserRepo.findByusername(username);
        ImproperFlagging improperFlagging = new ImproperFlagging(user);
            if (movie.getUserImproperflaging()
                    .stream()
                    .filter(flag -> flag.getUser().getId() == user.getId()).count() > 0) {
                return false;
            }
            else {
                movie.adduserImproprateflag(improperFlagging);
            }
            if (movie.getUserImproperflaging().size() == 10){
                movie.setImproper(true);
            }
            movierepo.save(movie);
        
        return true;
    }

    @Override
    public boolean markMovieImproper(Long movieid) {
        Movies movie =  getmovie(movieid);
        movie.setImproper(true);
       movierepo.save(movie);

        return true;

    }

    public Movies getmovie(Long movieid) {
        Optional<Movies> movie =  movierepo.findById(movieid);
        Movies selectedmovie = null;
        if(movie.isPresent())
            selectedmovie =  movie.get();
        
        return selectedmovie;
        
    }
}
