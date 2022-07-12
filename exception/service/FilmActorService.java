package com.example.demo.service;

import com.example.demo.model.FilmActor;
import com.example.demo.repository.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmActorService {
    @Autowired
    private FilmActorRepository filmActorRepository;

    public void save(FilmActor filmActorConn){
        filmActorRepository.save(filmActorConn);
    }
}
