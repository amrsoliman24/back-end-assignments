package controllers;

import entities.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ImproperMovieService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ImproperMovieService improperMovieService;
    @RequestMapping(value = "/markmovieasimproper" , method = RequestMethod.GET)
    public ResponseEntity<Movies> ImproperFlagging(@RequestParam(value = "movieid" ) Long id)
    {
        if(improperMovieService.markMovieImproper(id))
            return new ResponseEntity("movie has been marked Improper", HttpStatus.OK) ;
        return new ResponseEntity("movie is not found " , HttpStatus.NOT_FOUND) ;
    }
    @RequestMapping(value = "/impropervotedmovies" , method = RequestMethod.GET)
    public ResponseEntity<Movies> fetchTopMovies()  {
        if(improperMovieService.impropratemovies().size() == 0)
            return new ResponseEntity("no movies has been added yet", HttpStatus.NOT_FOUND) ;
        return new ResponseEntity(improperMovieService.impropratemovies() , HttpStatus.OK) ;
    }



}
