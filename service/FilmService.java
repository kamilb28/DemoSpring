package com.example.demo.service;

import com.example.demo.dto.FilmDto;
import com.example.demo.model.Actor;
import com.example.demo.model.Category;
import com.example.demo.model.Film;
import com.example.demo.model.Language;
import com.example.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final ActorService actorService;
    private final CategoryService categoryService;
    private final LanguageService languageService;

    public FilmService(FilmRepository filmRepository, ActorService actorService, CategoryService categoryService, LanguageService languageService){
        this.filmRepository = filmRepository;
        this.actorService = actorService;
        this.categoryService = categoryService;
        this.languageService = languageService;
    }


    public Film createFilm(FilmDto filmDto){
        Film film = new Film();
        film.setTitle(filmDto.getTitle());
        film.setDescription(filmDto.getDescription());
        film.setReleaseYear(filmDto.getReleaseYear());
        //film.setLanguageId(filmDto.getLanguageId()); ???
        film.setRentalDuration(filmDto.getRentalDuration());
        film.setRentalRate(filmDto.getRentalRate());
        film.setLength(filmDto.getLength());
        film.setReplacementCost(filmDto.getReplacementCost());
        film.setRating(filmDto.getRating());

        //tego chyba nie trzeba, bo jest od tego trigger w bazie
        film.setLastUpdate(LocalDateTime.now());
        film.setSpecialFeatures("null");
        film.setFulltext("null");

        return filmRepository.save(film);
    }

    public Iterable<Film> getAll(){
        return filmRepository.findAll();
    }

    public Optional<Film> getById(int id){
        return filmRepository.findById(id);
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public Film assignActorToFilm(Integer filmId, Integer actorId) {
        Film film = filmRepository.findById(filmId).get();
        Actor actor = actorService.getById(actorId).get();

        // Dodanie do listy aktorów aktora
        film.getActors().add(actor);

        // Aktualizacja filmu. JPA samo wykryje, że dodano nowe dowiązanie
        return filmRepository.save(film);
    }

    public Film assignCategoryToFilm(Integer filmId, Integer categoryId) {
        Film film = filmRepository.findById(filmId).get();
        Category category = categoryService.getById(categoryId).get();

        film.getCategories().add(category);

        return filmRepository.save(film);
    }

    public Film assignLanguageToFilm(Integer filmId, Integer languageId) {
        Film film = filmRepository.findById(filmId).get();
        Language language = languageService.getById(languageId).get();

        film.setLanguage(language);

        return filmRepository.save(film);
    }
}
