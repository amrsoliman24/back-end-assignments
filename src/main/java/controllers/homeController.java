package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.Gnere;
import entities.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reposotories.Movierepo;
import reposotories.GnereRepo;
import reposotories.userRepo;
import services.Movieservice;
import services.RecommendationService;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@RestController()
@RequestMapping("/home")
public class homeController {
@Autowired
userRepo UserRepo;
@Autowired
Movierepo movierepo;
@Autowired
GnereRepo gnereRepo;
@Autowired
Movieservice movieservice;
@Autowired
RecommendationService recommendationService;


    @RequestMapping(value = "/allmovies" , method = RequestMethod.GET)
    public ResponseEntity<Movies> fetchAllMovies(@RequestParam(value = "page") int page , @RequestParam(value = "size") int size )  {
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


    }


