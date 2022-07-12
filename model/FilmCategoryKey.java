package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class FilmCategoryKey implements Serializable {

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "category_id")
    private Integer categoryId;

    public FilmCategoryKey(Integer filmId, Integer categoryId){
        this.filmId = filmId;
        this.categoryId = categoryId;
    }
}
