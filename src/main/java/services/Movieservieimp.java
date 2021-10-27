package services;

import Dtos.GnereDto;
import Dtos.MovieDto;
import Dtos.MovieDtoList;
import entities.*;
import security.JwtManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reposotories.Movierepo;
import reposotories.GnereRepo;
import reposotories.userRepo;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class Movieservieimp implements Movieservice{
    @Autowired
    Movierepo movierepo;
    @Autowired
    GnereRepo gnereRepo;
    @Autowired
    JwtManager jwtManager;
    @Autowired
    userRepo UserRepo;
     private String apiKey = "6cd4d3a65001a41da5c411c2bf0ae0d8";
    @PostConstruct
    private void getGneres() {

        if(!gnereRepo.findAll().iterator().hasNext()){
            RestTemplate restTemplate = new RestTemplate();
            GnereDto response= restTemplate.getForObject("https://api.themoviedb.org/3/genre/movie/list?api_key=6cd4d3a65001a41da5c411c2bf0ae0d8&language=en-US" , GnereDto.class);
            response.getGenres().forEach(gnere -> {
                gnereRepo.save(gnere);
            });
        }
    }
    @PostConstruct
    private void getmovies() {
        int moviecount =0;
        Integer pagecount = 1;
        if(!movierepo.findAll().iterator().hasNext()) {
            while (moviecount != 100) {
                RestTemplate restTemplate = new RestTemplate();
                MovieDtoList response = restTemplate.getForObject("https://api.themoviedb.org/3/movie/top_rated?api_key="
                        + apiKey + "&language=en-US&page="
                        + pagecount.toString(), MovieDtoList.class);
                List<MovieDto> Movies = response.getResults();
                moviecount = moviecount + Movies.size();
                pagecount++;
                Movies.forEach(movieDto -> {
                    Movies movie = new Movies(movieDto);
                    movieDto.getGenre_ids().forEach(gnere -> {
                        Optional<Gnere> genre = gnereRepo.findById(gnere);
                        if (genre.isPresent()) {
                            Gnere movieGenere = genre.get();
                            movie.addgnere(movieGenere);
                        }

                    });
                    movierepo.save(movie);
                });

            }
        }
    }



    @Override
    public List<Movies> fetchMovies(int page , int size  ) {
        Pageable paging = PageRequest.of(page, size);
      Page<Movies> movies =  movierepo.getMoviesWithoutImproper(paging);
      return  movies.getContent();
    }

    @Override
    public List<Movies> fetchTopMovies() {
        return movierepo.getTopRated();
    }

    @Override
    public boolean rateMovie(Long id, String Auth , String rateValue ) {
        String username = jwtManager.extractUsername(Auth.substring(7));
        Optional<Movies> Movies =  movierepo.findById(id);
        user user = UserRepo.findByusername(username);
        BigDecimal rating = new BigDecimal(rateValue);
        MoviesRating moviesRating = new MoviesRating(user , rating);
        if(Movies.isPresent()){
            Movies movie =   Movies.get();
            if (movie.getUsersRating()
                    .stream()
                    .filter(rate -> rate.getUser().getId() == user.getId()).count() > 0) {
                return false;
            }
            movie.addMovieRating(moviesRating);
            movierepo.save(movie);
            movie.setRating(movierepo.getNewRating(movie.getId()));
            movierepo.save(movie);
        }
        return true;
    }






}

