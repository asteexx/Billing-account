package com.netcracker.gorbunov.backend.controller;

import com.netcracker.gorbunov.backend.entity.CategoryEntity;
import com.netcracker.gorbunov.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    private CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryEntity> getCategoryEntityById(@PathVariable(name = "id") Integer id) {
        Optional<CategoryEntity> categoryEntity = categoryService.getCategoryEntityById(id);
        if (categoryEntity.isPresent()) {
            return ResponseEntity.ok(categoryEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<CategoryEntity> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(method = RequestMethod.POST)
    public CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity) {
        return categoryService.saveCategory(categoryEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable(name = "id") Integer id) {
        categoryService.deleteCategory(id);
    }


}
