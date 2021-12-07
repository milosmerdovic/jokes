package com.zezalice.joke.repositories;

import com.zezalice.joke.entities.Jokes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesRepository extends JpaRepository<Jokes, Integer> {
}
