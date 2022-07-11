package com.example.demo.repository;

import com.example.demo.model.FilmActor;

import com.example.demo.model.FilmActorKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorKey> {

}
