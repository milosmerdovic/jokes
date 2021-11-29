package com.zezalice.joke.repositories;

import com.zezalice.joke.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {


}
