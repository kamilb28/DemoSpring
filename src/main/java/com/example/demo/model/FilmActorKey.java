package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Data
@Embeddable
public class FilmActorKey implements Serializable {
    @Column(name = "actor_id")
    private Integer actorID;

    @Column(name = "film_id")
    private Integer filmId;

    public FilmActorKey(Integer actorID, Integer filmId){
        this.actorID = actorID;
        this.filmId = filmId;
    }
}
