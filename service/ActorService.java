package com.example.demo.service;

import com.example.demo.model.Actor;
import com.example.demo.model.Film;
import com.example.demo.repository.ActorRepository;
import com.example.demo.dto.ActorDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;
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
        Actor actorToDelete = actorRepository.findById(id).get();

        for (Film film : actorToDelete.getFilms()){
            actorToDelete.removeFilm(film);
        }

        actorRepository.delete(actorToDelete);
        return "Actor " + id + " hes been deleted";
    }
}