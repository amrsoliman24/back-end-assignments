package reposotories;

import entities.Movies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.List;

public interface Movierepo extends PagingAndSortingRepository<Movies, Long> {
    //ToDO
    //ADD Pagination to get certain number of moveies
    @Query("select M from entities.Movies M order by M.rating Desc")
      List<Movies> getTopRated();
    @Query("select M from entities.Movies M where M.improper != TRUE")
     Page<Movies> getMoviesWithoutImproper(Pageable pageable);
    @Query("select AVG(M.rating) from entities.MoviesRating M where M.movie.id =?1")
     BigDecimal getNewRating(Long id );


}
