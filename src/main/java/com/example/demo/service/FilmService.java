package com.example.demo.service;

import com.example.demo.dto.FilmDto;
import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FilmService {
    final private FilmRepository filmRepository;
    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public String createFilm(FilmDto filmDto){
        Film film = new Film();
        film.setTitle(filmDto.getTitle());
        film.setDescription(filmDto.getDescription());
        film.setReleaseYear(filmDto.getReleaseYear());
        film.setLanguageId(filmDto.getLanguageId());
        film.setRentalDuration(filmDto.getRentalDuration());
        film.setRentalRate(filmDto.getRentalRate());
        film.setLength(filmDto.getLength());
        film.setReplacementCost(filmDto.getReplacementCost());
        film.setRating(filmDto.getRating());
        film.setLastUpdate(LocalDateTime.now());
        film.setSpecialFeatures("null");
        film.setFulltext("null");

        filmRepository.save(film);

        return "Film Saved";
    }

    public Iterable<Film> getAll(){
        return filmRepository.findAll();
    }

    public Optional<Film> getById(int id){
        return filmRepository.findById(id);
    }

    public void save(Film film) {
        filmRepository.save(film);
    }
}
