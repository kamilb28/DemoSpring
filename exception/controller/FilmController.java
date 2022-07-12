package com.example.demo.controller;

import com.example.demo.dto.ActorDto;
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

    public FilmController(FilmService filmService){
        this.filmService = filmService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Film> getAllFilms(){
        return filmService.getAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Film getFilmById(@PathVariable int id){
        Optional<Film> film = filmService.getById(id);
        if(film.isPresent()) return film.get();
        else throw new RecordNotFoundException();
    }

    @PostMapping(path="/add")
    public @ResponseBody Film addNewFilm (@RequestBody FilmDto filmDto){
        return filmService.createFilm(filmDto);
    }
}
