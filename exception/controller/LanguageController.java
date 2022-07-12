package com.example.demo.controller;

import com.example.demo.dto.LanguageDto;
import com.example.demo.model.Language;
import com.example.demo.service.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/language")
public class LanguageController {

    final private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping(path="/add")
    public @ResponseBody Language addLanguage(@RequestBody LanguageDto l){
        return languageService.addLanguage(l);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Language> allLanguages(){
        return languageService.getAllLanguages();
    }
}
