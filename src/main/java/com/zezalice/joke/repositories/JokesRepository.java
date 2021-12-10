package com.zezalice.joke.repositories;

import com.zezalice.joke.entities.Jokes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokesRepository extends JpaRepository<Jokes, Integer> {

    @Query(value = "SELECT * FROM zezalice.jokes ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public Jokes getRandomJoke();

    @Query("SELECT z FROM zezalice.jokes AS z order by function('RAND')")
    public List<Jokes> getRandomJokeFunction();
}
