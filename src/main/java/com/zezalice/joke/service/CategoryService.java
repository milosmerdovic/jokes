package com.zezalice.joke.service;

import com.zezalice.joke.entities.Categories;
import com.zezalice.joke.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> listAllCategories() {
        return categoriesRepository.findAll();
    }

    public Categories saveCategory(Categories category) {
        categoriesRepository.save(category);
        return category;
    }

    public Categories getCategory(Integer id) {
        return categoriesRepository.findById(id).get();
    }

    public void deleteCategory(Integer id) {
        categoriesRepository.deleteById(id);
    }
}
