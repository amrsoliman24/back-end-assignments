package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ImproperMovieService;
import services.Movieservice;
import services.RecommendationService;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController
{

@Autowired
Movieservice movieservice;
@Autowired
ImproperMovieService improperMovieService;
@Autowired
RecommendationService recommendationService ;



    @RequestMapping(value = "/ratemovie" , method = RequestMethod.GET)
    public ResponseEntity<Movies> rateMovie(@RequestHeader("Authorization") String auth,
                                            @RequestParam(value = "movieid" ) Long id,
                                            @RequestParam(value = "Rating" ) String rate)
    {
        if(movieservice.rateMovie(id ,auth,rate))
            return new ResponseEntity("Rating has been added successfully", HttpStatus.OK) ;
        return new ResponseEntity("user has added a rate already to the following movie" , HttpStatus.BAD_REQUEST) ;
    }

        @RequestMapping(value = "/flagmovie" , method = RequestMethod.GET)
    public ResponseEntity<Movies> ImproperFlagging(@RequestHeader("Authorization") String auth,
                                            @RequestParam(value = "movieid" ) Long id)
    {
        if(improperMovieService.addUserImproperFlag(id ,auth))
            return new ResponseEntity("movie has been flagged successfully", HttpStatus.OK) ;
        return new ResponseEntity("user has already flagged the movie before" , HttpStatus.BAD_REQUEST) ;
    }
    @RequestMapping(value = "/getrecomendemovies" , method = RequestMethod.GET)
    public Set<Movies> sayhi(@RequestHeader("Authorization") String Auth) throws JsonProcessingException {

        return recommendationService.recommendMoviesPerUserRating(Auth);
    }












}
