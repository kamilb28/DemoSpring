package com.example.demo.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer actorId;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private Set<FilmActor> filmActorConnections;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public void addConnection(FilmActor filmActorConnection) {
        filmActorConnections.add(filmActorConnection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Actor actor = (Actor) o;
        return actorId != null && Objects.equals(actorId, actor.actorId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
