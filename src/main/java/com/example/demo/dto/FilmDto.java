package com.example.demo.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
public class FilmDto {

    public String title;

    public String description;

    public Integer releaseYear;

    public short languageId;

    public short rentalDuration;

    public float rentalRate;

    public short length;

    public float replacementCost;

    public String rating;
}
