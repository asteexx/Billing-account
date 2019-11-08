package com.netcracker.gorbunov.backend.service.impl;

import com.netcracker.gorbunov.backend.entity.CategoryEntity;
import com.netcracker.gorbunov.backend.repository.CategoryRepository;
import com.netcracker.gorbunov.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        return repository.save(categoryEntity);
    }

    @Override
    public Optional<CategoryEntity> getCategoryEntityById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<CategoryEntity> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }
}
