package com.zezalice.joke.repositories;

import com.zezalice.joke.entities.Categories;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Categories, Integer> {


}
