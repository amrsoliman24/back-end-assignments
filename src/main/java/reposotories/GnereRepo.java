package reposotories;

import Dtos.MoviegneresDto;
import entities.Gnere;
import entities.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GnereRepo extends CrudRepository<Gnere,Integer> {
    @Query("select G.movie from entities.MovieGenere G where G.gnere.id = ?1 ")
    List<Movies> movieslistbyid(Integer id);



}
