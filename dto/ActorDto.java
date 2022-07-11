package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor //czy to musi byc jak nie mam innego konstruktora?
public class ActorDto {
    public String firstName;
    public String lastName;
}
