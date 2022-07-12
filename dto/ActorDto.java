package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ActorDto {
    public String firstName;
    public String lastName;

    public ActorDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
