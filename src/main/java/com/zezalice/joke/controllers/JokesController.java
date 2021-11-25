package com.zezalice.joke.controllers;

import com.zezalice.joke.entities.Jokes;
import com.zezalice.joke.repositories.JokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class JokesController {

    @Autowired
    private JokesRepository jokesRepository;

    @GetMapping("/jokes")
    public String listAll(Model model) {
        List<Jokes> listJokes = (List<Jokes>) jokesRepository.findAll();
        model.addAttribute("listJokes", listJokes);
        return "jokes";
    }
}
