package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FilmActor> filmActorConnections;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @Column(name = "language_id", nullable = false)
    private short languageId;

    @Column(name = "rental_duration", nullable = false)
    private short rentalDuration;

    @Column(name = "rental_rate", nullable = false)
    private float rentalRate;

    @Column(nullable = false)
    private short length;

    @Column(name= "replacement_cost", nullable = false)
    private float replacementCost;

    @Column(nullable = false)
    private String rating;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "special_features")
    private String specialFeatures;

    // chyba trzeba zrobic coustomowy
    // https://discourse.hibernate.org/t/postgres-tsvector-fields-and-hibernate/1838
    // https://vladmihalcea.com/postgresql-inet-type-hibernate/
    @Column
    private String fulltext;

    public void addConnection(FilmActor filmActorConnection) {
        filmActorConnections.add(filmActorConnection);
    }

    @Override
    public int hashCode() {
        return 11;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Actor other = (Actor) obj;
        return filmId != null && filmId.equals(other.getActorId());
    }
}
