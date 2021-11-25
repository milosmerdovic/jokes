package com.zezalice.joke.controllers;

import com.zezalice.joke.repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jokes")
public class JokesController {

    @Autowired
    private JokesRepository jokesRepository;

    @GetMapping
    public Iterable listAll() {
        return jokesRepository.findAll();
    }
}
