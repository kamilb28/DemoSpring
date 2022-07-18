package com.example.demo.service;

import com.example.demo.dto.LanguageDto;
import com.example.demo.model.Language;
import com.example.demo.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language addLanguage(LanguageDto languageDto){
        Language l = new Language();
        l.setName(languageDto.getName());
        l.setLastUpdate(LocalDateTime.now());

        return languageRepository.save(l);
    }

    public Iterable<Language> getAllLanguages(){
        return languageRepository.findAll();
    }

    public Optional<Language> getById(Integer languageId) {
        return languageRepository.findById(languageId);
    }
}
