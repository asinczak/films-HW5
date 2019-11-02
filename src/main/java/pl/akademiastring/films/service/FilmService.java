package pl.akademiastring.films.service;

import org.springframework.stereotype.Service;
import pl.akademiastring.films.model.Film;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private List<Film> filmList;

    public FilmService() {
        this.filmList = new ArrayList<>();
        filmList.add(new Film("Skazani na Shawshank", "1994", "USA"));
        filmList.add(new Film("Nietyklani", "2011", "Francja"));
        filmList.add(new Film("Joker", "2019", "USA"));
        filmList.add(new Film("Lista Schindlera", "1993", "USA"));
        filmList.add(new Film("Siedem", "1995", "USA"));
        filmList.add(new Film("Django", "2012", "USA"));
    }

    public List<Film> getFilms(){
        return filmList;
    }

    public boolean addFilm(Film film){
       return filmList.add(film);
    }
}
