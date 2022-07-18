package com.example.demo.notuserepos;

import com.example.demo.notusemodels.FilmActor;

import com.example.demo.notusemodels.FilmActorKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorKey> {

}
