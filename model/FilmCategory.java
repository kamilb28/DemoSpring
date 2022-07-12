package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "film_category")
@NoArgsConstructor
public class FilmCategory {

    @EmbeddedId
    private FilmCategoryKey id;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
