package com.zezalice.joke.controllers;

import com.zezalice.joke.entities.Jokes;
import com.zezalice.joke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/jokes")
public class JokesController {

    @Autowired
    private JokeService jokeService;

    @GetMapping
    public Iterable listAll() {
        return jokeService.listAllJokes();
    }

    @GetMapping("/{id}")
    public Jokes findOneById(@PathVariable int id) {
        Jokes joke = jokeService.getJoke(id);
        if (joke != null) {
            return joke;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jokes create(@RequestBody Jokes joke) {
        return jokeService.saveJoke(joke);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Jokes jokes, @PathVariable Integer id) {
        try {
            Jokes existingJoke = jokeService.getJoke(id);
            jokes.setId(id);
            jokeService.saveJoke(jokes);
            return new ResponseEntity<>(OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        jokeService.deleteJoke(id);
    }
}