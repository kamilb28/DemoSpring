package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryDto {
    public String name;
    public CategoryDto(String name){
        this.name = name;
    }
}
