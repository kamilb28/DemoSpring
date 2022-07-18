package com.example.demo.controller;

import com.example.demo.dto.FilmDto;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Film;
import com.example.demo.service.FilmService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/film")
public class FilmController {
    final private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Film> getAllFilms() {
        return filmService.getAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Film getFilmById(@PathVariable int id) {
        return filmService.getById(id).get();
    }

    @PostMapping(path = "/add")
    public @ResponseBody Film addNewFilm(@RequestBody FilmDto filmDto) {
        return filmService.createFilm(filmDto);
    }

    @PutMapping(path = "/{filmId}/actor/{actorId}")
    public @ResponseBody Film actorToFilm(
            @PathVariable Integer filmId,
            @PathVariable Integer actorId
    ) {
        return filmService.assignActorToFilm(filmId, actorId);
    }

    @PutMapping(path = "/{filmId}/category/{categoryId}")
    public @ResponseBody Film categoryToFilm(
            @PathVariable Integer filmId,
            @PathVariable Integer categoryId
    ) {
        return filmService.assignCategoryToFilm(filmId, categoryId);
    }

    @PutMapping(path = "/{filmId}/language/{languageId}")
    public @ResponseBody Film languageToFilm(
            @PathVariable Integer filmId,
            @PathVariable Integer languageId
    ) {
        return filmService.assignLanguageToFilm(filmId, languageId);
    }
}
