package reposotories;

import entities.Gnere;
import entities.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface Movierepo extends PagingAndSortingRepository<Movies, Long> {
    //ToDO
    //ADD Pagination to get certain number of moveies
    @Query("select M from entities.Movies M order by M.rating Desc")
      List<Movies> getTopRated();
    @Query("select M from entities.Movies M where M.improper != TRUE")
     Page<Movies> getMoviesWithoutImproper(Pageable pageable);
    @Query("select AVG(M.rating) from entities.MoviesRating M where M.movie.id =?1")
     BigDecimal getNewRating(Long id );
    @Query("select M.movie.gneres from entities.MoviesRating M where M.user.id =?1 and M.rating > 8.0")
    Set<Gnere> getUserHighlyRatedMovies(Long id );
    @Query("select M  from entities.Movies M join M.gneres g where g.id = ?1 and M.rating > 7.0")
    Set<Movies> findBygneres(Integer id );
    @Query("select IF.movie  from entities.ImproperFlagging IF")
    Set<Movies> getflaggedmovies();



}
