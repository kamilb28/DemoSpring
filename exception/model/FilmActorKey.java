package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class FilmActorKey implements Serializable {
    @Column(name = "actor_id")
    private Integer actorID;

    @Column(name = "film_id")
    private Integer filmId;

    public FilmActorKey(Integer actorID, Integer filmId){
        this.actorID = actorID;
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        FilmActorKey other = (FilmActorKey) obj;
        if (actorID == null) {
            if (other.actorID != null)
                return false;
        } else if (!actorID.equals(other.actorID))
            return false;
        if (filmId == null) {
            if (other.filmId != null)
                return false;
        } else if (!filmId.equals(other.filmId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actorID == null) ? 0 : actorID.hashCode());
        result = prime * result + ((filmId == null) ? 0 : filmId.hashCode());
        return result;
    }
}
