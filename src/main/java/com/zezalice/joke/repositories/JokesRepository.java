package com.zezalice.joke.repositories;

import com.zezalice.joke.entities.Jokes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesRepository extends CrudRepository<Jokes, Integer> {
}
