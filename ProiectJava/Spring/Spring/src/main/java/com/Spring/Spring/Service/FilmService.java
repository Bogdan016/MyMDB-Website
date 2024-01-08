package com.Spring.Spring.Service;

import com.Spring.Spring.Entity.FilmEntity;
import com.Spring.Spring.Repository.FilmInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmInterface filmInterface;

    public FilmEntity saveDetails(FilmEntity entry) {
        return filmInterface.save(entry);
    }

    public List<FilmEntity> getDetails() {
        return filmInterface.findAll();
    }

    public List<FilmEntity> findMoviesByGenre(String genre) {
        return filmInterface.findMoviesByGenre(genre);
    }

    public List<FilmEntity> findFilmDetails(String title, int year) {
        return filmInterface.findFilmDetails(title, year);
    }

    public List<FilmEntity> findMoviesWithGreaterDuration(String title, int year) {
        return filmInterface.findMoviesWithGreaterDuration(title, year);
    }

}
