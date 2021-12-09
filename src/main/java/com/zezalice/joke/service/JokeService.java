package com.zezalice.joke.service;

import com.zezalice.joke.entities.Jokes;
import com.zezalice.joke.repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JokeService {

    @Autowired
    private JokesRepository jokesRepository;

    public List<Jokes> listAllJokes() {
        return jokesRepository.findAll();
    }

    public Jokes saveJoke(Jokes joke) {
        jokesRepository.save(joke);
        return joke;
    }

    public Jokes getJoke(Integer id) {
        return jokesRepository.findById(id).get();
    }

    public Jokes getRandomJoke() {
        return jokesRepository.getRandomJoke();
    }
    public void deleteJoke(Integer id) {
        jokesRepository.deleteById(id);
    }

}
