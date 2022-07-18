package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();

    /*
    Stare podejście z tabelą przejściową
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<FilmActor> filmActorConnections;
     */

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "release_year", nullable = false)
    private Integer releaseYear;

    @ManyToMany
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    private Language language;

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

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column
    private String fulltext;

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
