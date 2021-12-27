package com.zezalice.joke.repositories;

import com.zezalice.joke.entities.Jokes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokesRepository extends JpaRepository<Jokes, Integer> {

    @Query(value = "SELECT * FROM zezalice.jokes ORDER BY RAND() LIMIT 1", nativeQuery = true)
    public Jokes getRandomJoke();

    /*
    * Instead of %:query% it can be use this format:
    * %?1% where 1, 2 or any other number is a place-holder for the exact
    * number of parameters
    * */

    @Query(value = "SELECT * FROM zezalice.jokes WHERE joke_text LIKE %:query%" , nativeQuery = true)
    public List<Jokes> findBySearchQuery(@Param("query") String query);

    /*@Query("SELECT z FROM zezalice.jokes AS z order by function('RAND')")
    public List<Jokes> getRandomJokeFunction();*/
}
