package services;

import entities.ImproperFlagging;
import entities.Movies;
import entities.user;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import reposotories.Movierepo;
import reposotories.userRepo;
import security.JwtManager;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ImproperMovieServiceImpTest {
    @Spy
    Movierepo movierepo;
    @Mock
    Set<ImproperFlagging> set;
    @Mock
    Stream<ImproperFlagging> stream;
    @Spy
    userRepo UserRepo;
    @Mock
    JwtManager jwtManager;
    @Mock
    Movies moviesEntity;
    @InjectMocks
    ImproperMovieServiceImp improperMovieServiceImp = new ImproperMovieServiceImp();

    @BeforeEach
    public void Mocksinit() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addUserImproperFlag() {
        user User = new user();
        User.setId(1L);
        Movies  movie =  new Movies();
        movie.setId(1L);
        Set<ImproperFlagging> list = new HashSet<>();
        movie.setUserImproperflaging(list);
        Mockito.when(jwtManager.extractUsername(Mockito.anyString())).thenReturn("test");
        Optional<Movies> moviesOptional  = Optional.of(movie);
        String Auth = "fdfgdfbfddjjshshvhffdsssdghhbb";
        Mockito.when(movierepo.findById(Mockito.anyLong())).thenReturn(moviesOptional);
        Mockito.when(UserRepo.findByusername(Mockito.anyString())).thenReturn(User);
        ImproperFlagging improperFlagging = new ImproperFlagging(User);
        Mockito.when(moviesEntity.adduserImproprateflag(Mockito.any())).thenReturn(true);
      //  movie.adduserImproprateflag(improperFlagging);
        list.add(improperFlagging);
        Stream<ImproperFlagging> listStream = list.stream();
        Mockito.when(moviesEntity.getUserImproperflaging()).thenReturn(list);
        Mockito.when(set.stream()).thenReturn(listStream);
        Mockito.when(stream.filter(Mockito.any())).thenReturn(listStream);
        Mockito.when(stream.count()).thenReturn(0L);
        when(moviesEntity.adduserImproprateflag(improperFlagging)).thenReturn(true);
        assertEquals(improperMovieServiceImp.addUserImproperFlag(Mockito.anyLong(),Auth),false);





    }

    @Test
    void markMovieImproper() {
        Movies  movie =  new Movies();
        Optional<Movies> moviesOptional  = Optional.of(movie);
        movie.setId(1L);
        movie.setImproper(false);
        Mockito.when(movierepo.findById(Mockito.anyLong())).thenReturn(moviesOptional);
        Mockito.when(movierepo.save(movie)).thenReturn(null);
        assertEquals(movierepo.findById(Mockito.anyLong()) , moviesOptional);
        assertEquals(improperMovieServiceImp.markMovieImproper(Mockito.anyLong()),movie.isImproper());

    }

    @Test
    void getmovie() {
        MockitoAnnotations.initMocks(this);
        Movies movie =  new Movies();
        movie.setName("testing here");
        Optional<Movies> movies  = Optional.of(movie);
        Mockito.when(movierepo.findById(Mockito.anyLong())).thenReturn(movies);
        assertEquals(improperMovieServiceImp.getmovie(Mockito.anyLong()).getName(),movie.getName());
    }
}