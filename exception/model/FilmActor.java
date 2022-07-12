package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "film_actor")
@NoArgsConstructor
public class FilmActor {

    @EmbeddedId
    private FilmActorKey id;

    public FilmActor(FilmActorKey id, LocalDateTime ldt){
        this.id = id;
        this.lastUpdate = ldt;
    }

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "actor_id")
    @JsonIgnore
    private Actor actor;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    private Film film;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
