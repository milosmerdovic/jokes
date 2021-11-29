package com.zezalice.joke.controllers;

import com.zezalice.joke.entities.Categories;
import com.zezalice.joke.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Iterable listAll() {
        return categoryService.listAllCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categories create(@RequestBody Categories category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Categories category, @PathVariable Integer id) {
        try {
            Categories existingCategory = categoryService.getCategory(id);
            category.setId(id);
            categoryService.saveCategory(category);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
