package Dtos;

import entities.Gnere;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GnereDto {


    private List<Gnere> genres ;

    public  GnereDto(){

    }

    public List<Gnere> getGenres() {
        return genres;
    }

    public void setGenres(List<Gnere> genres) {
        this.genres = genres;
    }
}
