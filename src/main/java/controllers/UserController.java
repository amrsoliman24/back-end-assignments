package controllers;

import entities.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ImproperMovieService;
import services.Movieservice;
@RestController
public class UserController
{

@Autowired
Movieservice movieservice;
@Autowired
ImproperMovieService improperMovieService;


    @RequestMapping(value = "/allmovies" , method = RequestMethod.GET)
    public ResponseEntity<Movies> fetchAllMovies(@RequestParam(value = "page") int page ,@RequestParam(value = "size") int size )  {
        if(movieservice.fetchMovies(page, size).size() == 0)
            return new ResponseEntity("no movies has been added yet", HttpStatus.NOT_FOUND) ;
     return new ResponseEntity(movieservice.fetchMovies(page ,size) , HttpStatus.OK) ;
    }
    @RequestMapping(value = "/topmovies" , method = RequestMethod.GET)
    public ResponseEntity<Movies> fetchTopMovies()  {
        if(movieservice.fetchTopMovies().size() == 0)
            return new ResponseEntity("no movies has been added yet", HttpStatus.NOT_FOUND) ;
        return new ResponseEntity(movieservice.fetchTopMovies() , HttpStatus.OK) ;
    }
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












}
