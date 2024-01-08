package com.Spring.Spring.Controller;

import com.Spring.Spring.Entity.FilmEntity;
import com.Spring.Spring.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:5500")
@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping("/addFilm")
    public FilmEntity postDetails(@RequestBody FilmEntity entry) {
        return filmService.saveDetails(entry);
    }

    @GetMapping("/getFilm")
    public List<FilmEntity> getDetails() {
        return filmService.getDetails();
    }

    @GetMapping("/getMoviesByGenre")
    public List<FilmEntity> getMoviesByGenre(@RequestParam String genre) {
        return filmService.findMoviesByGenre(genre);
    }

    @GetMapping("/getFilmDetails")
    public List<FilmEntity> getFilmDetails(@RequestParam String title, @RequestParam int year) {
        return filmService.findFilmDetails(title, year);
    }

    @GetMapping("/getMoviesWithGreaterDuration")
    public List<FilmEntity> getMoviesWithGreaterDuration(@RequestParam String title, @RequestParam int year) {
        return filmService.findMoviesWithGreaterDuration(title, year);
    }

}
