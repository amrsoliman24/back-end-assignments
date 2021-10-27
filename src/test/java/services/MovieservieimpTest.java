package services;

import entities.ImproperFlagging;
import entities.Movies;
import entities.MoviesRating;
import entities.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import reposotories.Movierepo;
import reposotories.userRepo;
import security.JwtManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MovieservieimpTest {
    @Mock
    Page<Movies> page;
    @Spy
    Movierepo movierepo;
    @Mock
    Set<ImproperFlagging> set;

    @Mock
    Stream<MoviesRating> stream;
    @Spy
    userRepo UserRepo;
    @Mock
    JwtManager jwtManager;
    @Mock
    Movies moviesEntity;
    @Mock
    user User;
    @Mock
    Set<MoviesRating> userRating;
    @InjectMocks
    Movieservieimp movieservieimp = new Movieservieimp();
    @BeforeEach
    public void Mocksinit() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void fetchMovies() {
        Pageable Page =  PageRequest.of(0,1);
        Movies movie = new Movies();
        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(movie);
        Mockito.when(movierepo.getMoviesWithoutImproper(Page)).thenReturn(page);
        Mockito.when(page.getContent()).thenReturn(moviesList);
        assertEquals(movieservieimp.fetchMovies(0,1).size(), moviesList.size());
    }

    @Test
    void fetchTopMovies() {
        Movies movie = new Movies();
        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(movie);
        Mockito.when(movierepo.getTopRated()).thenReturn(moviesList);
        assertEquals(movieservieimp.fetchTopMovies().size(), moviesList.size());

    }

    @Test
    void rateMovie() {
        String Auth = "fdfgdfbfddjjshshvhffdsssdghhbb";
        Mockito.when(jwtManager.extractUsername(Mockito.anyString())).thenReturn("test");
        Mockito.when(UserRepo.findByusername(Mockito.anyString())).thenReturn(User);
        Mockito.when(moviesEntity.getUsersRating()).thenReturn(userRating);
        Mockito.when(userRating.stream()).thenReturn(stream);
        Mockito.when(stream.filter(Mockito.any())).thenReturn(stream);
        Mockito.when(stream.count()).thenReturn(0L);
        Mockito.when(movierepo.save(moviesEntity)).thenReturn(null);
        assertTrue(movieservieimp.rateMovie(Mockito.anyLong(), Auth, "7.5"));

    }
}