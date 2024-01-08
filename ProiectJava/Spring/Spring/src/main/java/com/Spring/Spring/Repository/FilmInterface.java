package com.Spring.Spring.Repository;

import com.Spring.Spring.Entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmInterface extends JpaRepository<FilmEntity, String> {
    @Query("SELECT f FROM FilmEntity f WHERE f.gen = :genre ORDER BY f.an ASC, f.titlu ASC")
    List<FilmEntity> findMoviesByGenre(@Param("genre") String genre);

    @Query("SELECT f FROM FilmEntity f JOIN FETCH f.studioEntity s JOIN FETCH f.producator p WHERE f.titlu = :title AND f.an = :year")
    List<FilmEntity> findFilmDetails(@Param("title") String title, @Param("year") int year);

    @Query("SELECT f FROM FilmEntity f WHERE f.durata > ALL(SELECT f2.durata FROM FilmEntity f2 WHERE f2.titlu = :title AND f2.an = :year)")
    List<FilmEntity> findMoviesWithGreaterDuration(@Param("title") String title, @Param("year") int year);

}
//    SELECT titlu, an, durata
//    FROM Film
//    WHERE durata > ALL (
//        SELECT durata
//        FROM Film
//        WHERE titlu = 'Bohemian Rhapsody' AND an = 2018
//        );
