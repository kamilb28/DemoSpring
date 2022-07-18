package com.example.demo.notuseservices;

import com.example.demo.notusemodels.FilmActor;
import com.example.demo.notuserepos.FilmActorRepository;
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
