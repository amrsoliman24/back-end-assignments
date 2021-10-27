package reposotories;

import Dtos.MoviegneresDto;
import entities.Gnere;
import entities.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface GnereRepo extends CrudRepository<Gnere,Integer> {
    @Query("select G.Movies from entities.Gnere G where G.id = ?1 ")
    Set<Movies> movieslistbyid(Integer id);



}
