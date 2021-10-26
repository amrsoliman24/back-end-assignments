package services;

import org.springframework.stereotype.Service;

@Service
public interface ImproperMovieService {
    public boolean addUserImproperFlag(Long id , String Auth);
    public boolean markMovieImproper(Long movieid);
}
