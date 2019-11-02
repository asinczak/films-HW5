package pl.akademiastring.films.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.akademiastring.films.aspect.FilmAnno;
import pl.akademiastring.films.model.Film;
import pl.akademiastring.films.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmApi {

    private FilmService filmService;

    @Autowired
    public FilmApi(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getFilms(){
        return new ResponseEntity<>(filmService.getFilms(), HttpStatus.OK);
    }

    @FilmAnno
    @PostMapping
    public ResponseEntity addFilm(@RequestBody Film film){
        if (filmService.addFilm(film)) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
