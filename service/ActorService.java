package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.model.Film;
import com.example.demo.model.FilmActor;
import com.example.demo.model.FilmActorKey;
import com.example.demo.repository.ActorRepository;
import com.example.demo.dto.ActorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private final ActorRepository actorRepository;

    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmActorService filmActorService;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor createActor(ActorDto actorDto) {
        Actor actor = new Actor();
        actor.setFirstName(actorDto.firstName);
        actor.setLastName(actorDto.lastName);
        actor.setLastUpdate(LocalDateTime.now());

        return actorRepository.save(actor);
    }

    public Iterable<Actor> getAll() {
        return actorRepository.findAll();
    }

    public Optional<Actor> getById(int id) {
        return actorRepository.findById(id);
    }

    public String updateActor(int id, ActorDto actorDto) {
        actorRepository.findById(id)
                .map(actor -> {
                    actor.setFirstName(actorDto.getFirstName());
                    actor.setLastName(actorDto.getLastName());
                    actor.setLastUpdate(LocalDateTime.now());
                    return actorRepository.save(actor);
                });

        return "Actor " + id + " Updated";
    }

    public String deleteActor(int id) {
        actorRepository.deleteById(id);
        return "Actor " + id + " hes been deleted";
    }

    public String assignActorToFilm(int actorId, int filmId) {

        FilmActor filmActorConnection = new FilmActor(
                new FilmActorKey(actorId, filmId),
                LocalDateTime.now()
        );

        Actor actor = actorRepository.findById(actorId).get();
        Film film = filmService.getById(filmId).get();


        filmActorConnection.setActor(actor);
        filmActorConnection.setFilm(film);

        actor.addConnection(filmActorConnection);
        film.addConnection(filmActorConnection);

        actorRepository.save(actor);
        filmService.save(film);
        filmActorService.save(filmActorConnection);

        return "Actor: " + actorId + " assigned to Film: " + filmId;
    }
}