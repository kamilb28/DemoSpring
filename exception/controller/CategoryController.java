package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/category")
public class CategoryController {

    final private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping(path="/add")
    public @ResponseBody Category addNewCategory (@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCategories(){
        return categoryService.getAll();
    }
}
