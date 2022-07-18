package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.dto.ActorDto;
import com.example.demo.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import com.example.demo.exception.RecordNotFoundException;

@Controller
@RequestMapping(path="/actor")
public class ActorController {

    final private ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @PostMapping(path="/add")
    public @ResponseBody Actor addNewActor (@RequestBody ActorDto actorDto){
        return actorService.createActor(actorDto);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Actor> getAllActors(){
        return actorService.getAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Actor getActor(@PathVariable int id){
        Optional<Actor> actor = actorService.getById(id);
        if(actor.isPresent()) return actor.get();
        else throw new RecordNotFoundException();
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String update(@PathVariable int id, @RequestBody ActorDto actorDto){
        Optional<Actor> actor = actorService.getById(id);
        if(actor.isEmpty()) throw new RecordNotFoundException();
        return actorService.updateActor(id, actorDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String delete(@PathVariable int id){
        Optional<Actor> actor = actorService.getById(id);
        if(actor.isEmpty()) throw new RecordNotFoundException();
        return actorService.deleteActor(id);
    }
}
