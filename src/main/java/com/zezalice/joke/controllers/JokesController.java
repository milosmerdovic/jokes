package com.zezalice.joke.controllers;

import com.zezalice.joke.entities.Jokes;
import com.zezalice.joke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class JokesController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/jokes")
    public List<Jokes> listAll() {
        return jokeService.listAllJokes();
    }

    @GetMapping("/random-joke")
    public Jokes getRandomJoke() {
        return jokeService.getRandomJoke();

        // Uncomment following block of code in order to parse wrong characters into serbian latin letters

        /*Jokes randJoke = jokeService.getRandomJoke();
        String jokeText = randJoke.getJoke();
        System.out.println(jokeText);

        jokeText = new String(jokeText.getBytes("windows-1250"), "UTF-8");

        randJoke.setJoke(jokeText);

        return randJoke;*/
    }

    @GetMapping("/jokes/{id}")
    public Jokes findOneById(@PathVariable int id) {
        return jokeService.getJoke(id);
    }

    @GetMapping("/search-jokes")
    public List<Jokes> searchJokes(@RequestParam("query") String query) {
        if (query != null) {
            System.out.println(jokeService.searchJokes(query));
            return jokeService.searchJokes(query);
        } else {
            return jokeService.listAllJokes();
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